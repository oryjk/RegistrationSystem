package com.wangrui.registrationsystem.ticket.adaptor.input.rest

import com.wangrui.registrationsystem.ticket.application.port.input.HomeScheduleUseCase
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created on 2024/2/29 11:59.
 * @author wangrui
 * @since 0.0.1
 */

@RestController
@RequestMapping("/api/schedule")
@CrossOrigin
class HomeScheduleController(val homeScheduleUseCase: HomeScheduleUseCase) {

    @GetMapping("/list")
    fun getHomeSchedule(): List<HomeScheduleUseCase.Schedule> {
        return homeScheduleUseCase.queryAll()
    }
}