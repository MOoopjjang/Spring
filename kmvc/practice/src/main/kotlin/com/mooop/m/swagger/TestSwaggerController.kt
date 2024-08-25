package com.mooop.m.swagger

import com.mooop.core.vo.ApiResponse
import com.mooop.m.swagger.vo.STestVO
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Profile
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.validation.Valid

/**
 * Project: kmvc
 * Package :com.mooop.m.swagger.config
 * Author : mooopjjang
 * Date 2023/01/29
 * DESC :
 */
@Profile("swagger")
@Tag(name = "Test API")
@RestController
@RequestMapping("/sw/test")
class TestSwaggerController {

    val log = LoggerFactory.getLogger(TestSwaggerController::class.java)

    @Operation(summary = "테스트 t1")
    @PostMapping("/t1")
    fun t1(@Valid @RequestBody param: STestVO):ApiResponse<String> {
        log.info(">>> param = {}" , param)
        return ApiResponse.ok("SUCCESS")
    }
}