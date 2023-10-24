package com.wangrui.registrationsystem.activity.adapter.input.rest

import com.wangrui.registrationsystem.activity.adapter.input.request.UserActivityRequest
import com.wangrui.registrationsystem.activity.application.port.input.UserActivityUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user-activity")
class UserActivityController(val userActivityUseCase: UserActivityUseCase) {

    @PostMapping("/registration")
    fun registration(@RequestBody userActivityRequest: UserActivityRequest) {
        userActivityUseCase.register(UserActivityRequest.toUserActivity(userActivityRequest))
    }
}