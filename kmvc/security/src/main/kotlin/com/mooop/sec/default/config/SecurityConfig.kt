package com.mooop.sec.default.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

/**
 * Project : kmvc
 * Package :com.mooop.sec.default.config
 * Author :  zinnaworks
 * Date : 09/04/2022
 * Desc :
 */
@Configuration
class SecurityConfig
constructor( val customAuthenticationProvider: CustomAuthenticationProvider) : WebSecurityConfigurerAdapter(){
    val IGNORE_URI = arrayOf("/resources/**")

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.authenticationProvider(customAuthenticationProvider)
    }

    override fun configure(web: WebSecurity?) {
        web!!.ignoring().antMatchers("/resources/**")
    }

    override fun configure(http: HttpSecurity?) {
        http!!.
                httpBasic().disable()
            .headers().frameOptions().sameOrigin()
            .and()
            .authorizeRequests()
            .antMatchers("/auth/**").permitAll()
            .antMatchers("/main/m").hasRole("USER")
            .antMatchers("/admin/m").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
            .csrf()


        http!!.formLogin()
            .loginPage("/auth/login")
            .usernameParameter("username")
            .passwordParameter("password")
            .loginProcessingUrl("/j_spring_security_check")
            .successHandler(loginSuccessHandler())
            .failureHandler(loginFailureHandler())
            .and()
            .logout()
            .logoutUrl("/auth/logout")
//            .logoutSuccessUrl("/auth/login")
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
            .clearAuthentication(true)



    }

    @Bean
    fun loginSuccessHandler():LoginSuccessHandler = LoginSuccessHandler()

    @Bean
    fun loginFailureHandler():LoginFailureHandler = LoginFailureHandler()

}

