package com.wangrui.registrationsystem.activity.adapter.input.rest

import com.wangrui.registrationsystem.activity.adapter.input.request.ActivityInfoRequest
import com.wangrui.registrationsystem.activity.application.port.input.ActivityInfoUserCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/activity-info")
class ActivityInfoController(val activityInfoUserCase: ActivityInfoUserCase) {

    @PostMapping("/create")
    fun createActivityInfo(@RequestBody activityInfoRequest: ActivityInfoRequest) {
        activityInfoUserCase.create(ActivityInfoRequest.toActivityInfo(activityInfoRequest))
    }
}