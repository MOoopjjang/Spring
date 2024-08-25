package com.mooop.core.jwt

import com.mooop.core.jwt.vo.JwtVo
import com.mooop.core.jwt.vo.TokenUserVo
import com.mooop.core.utils.DateUtil
import io.jsonwebtoken.*
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.security.Key
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import javax.annotation.PostConstruct
import javax.servlet.http.HttpServletRequest

/**
 * Project : kmvc
 * Package :com.mooop.core.jwt
 * Author :  zinnaworks
 * Date : 10/04/2022
 * Desc :
 */
@Service("jwtDetailsService")
class JwtDetailsService {

    @Value("\${jwt.access-expire}")
    lateinit var ACCESS_TOKEN_VALIDATION_SECOND:Integer
    @Value("\${jwt.refresh-expire}")
    lateinit var REFRESH_TOKEN_VALIDATION_DAY:Integer
    @Value("\${jwt.secret}")
    lateinit var sec:String

    var secretKey:Key? = null

    @PostConstruct
    fun init(){
        secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(sec))
    }


    /**
     * JWT 생성
     */
    fun createToken(tokenUserVo:TokenUserVo):JwtVo{

        val claims:Claims = Jwts.claims()
        claims[KEY_TOKEN_USER] = tokenUserVo

        val now:LocalDateTime = LocalDateTime.now(ZoneId.of("Asia/Seoul"))
        val expireTime:LocalDateTime = now.plusMinutes(ACCESS_TOKEN_VALIDATION_SECOND.toLong())
        val refreshTime:LocalDateTime = now.plusDays(REFRESH_TOKEN_VALIDATION_DAY.toLong())

        val accessToken:String = createJwt(claims , expireTime)
        val refreshToken:String = createJwt(claims , refreshTime)
        return JwtVo(accessToken , refreshToken)
    }


    fun validationToken(token:String):Boolean{
        try{
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token)
            return true
        } catch (e :SecurityException   ) {
            println("잘못된 JWT 서명입니다.")
        } catch(e: MalformedJwtException){
            println("잘못된 JWT 서명입니다.")
        } catch (e:ExpiredJwtException){
            println("만료된 JWT 토큰입니다.")
        } catch (e:UnsupportedJwtException){
            println("지원되지 않는 JWT 토큰입니다.")
        } catch (e:IllegalArgumentException){
            println("JWT 토큰이 잘못되었습니다.")
        }
        return false
    }

    /**
     * access token을 header에서 추출한다.
     */
    fun extractAccessToken(request:HttpServletRequest):String? = request.getHeader(X_ACCESS_TOKEN)?:null

    /**
     * refresh token을 header에서 추출한다.
     */
    fun extractRefreshToken(request:HttpServletRequest):String? = request.getHeader(X_REFRESH_TOKEN)?:null


    /**
     * JWT body를 TokenUserVo로 변환후 반환
     */
    fun extractUserInfo(token:String):TokenUserVo =
        validTokenAndReturnBody(token)
            .let {
                val m = it[KEY_TOKEN_USER] as MutableMap<String, Any>
                val l = it[KEY_ROLES] as MutableList<String>
                TokenUserVo(m[KEY_USERNAME] as String , "" , l.toTypedArray<String>())
            }


    /**
     * Token 유효성 체크 & Token body 반환
     */
    fun validTokenAndReturnBody(token:String):Claims =
        Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token)
            .body


    /**
     * JWT 생성후 반환한다.
     */
    fun createJwt(claims:Claims , expireTime:LocalDateTime):String{
        val dExpire = DateUtil.convertLocalDateTimeToDate(expireTime)
        val dNow = DateUtil.convertLocalDateTimeToDate(LocalDateTime.now(ZoneId.of("Asia/Seoul")))
        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(dNow)
            .setExpiration(dExpire)
            .signWith(secretKey , SignatureAlgorithm.HS512)
            .compact()
    }

}


const val KEY_USERNAME:String = "username"
const val KEY_ROLES:String = "roles"
const val KEY_TOKEN_USER:String = "TOKEN-USER"
const val X_ACCESS_TOKEN:String = "X-ACCESS-TOKEN"
const val X_REFRESH_TOKEN:String = "X-REFRESH-TOKEN";