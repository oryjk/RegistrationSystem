package com.wangrui.registrationsystem.tools.adaptor.`in`

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

/**
 * Created on 2023/3/21 11:15.
 * @author wangrui
 * @since 0.0.1
 */

@RestController
@RequestMapping("/api/tools/heart")
class HeatController {

    private val logger = LoggerFactory.getLogger(HeatController::class.java)
    private val random = Random(1000)
    @GetMapping("/default")
    fun getHeart(): String {
        val heartMsg = "Connected!!! ${random.nextInt()}"
        logger.info("heart message is $heartMsg")
        return heartMsg
    }
}

