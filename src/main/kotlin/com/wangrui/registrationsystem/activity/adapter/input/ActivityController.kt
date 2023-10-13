package com.wangrui.registrationsystem.activity.adapter.input

import com.wangrui.registrationsystem.activity.adapter.application.input.ActivityUseCase
import com.wangrui.registrationsystem.activity.adapter.input.request.ActivityRequest
import com.wangrui.registrationsystem.activity.domain.Activity
import com.wangrui.registrationsystem.common.slf4j
import org.slf4j.Logger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

/**
 * Created on 2023/10/13 14:48.
 * @author wangrui
 * @since 0.0.1
 */

@RestController
@RequestMapping("/api/activity")
class ActivityController(val activityUseCase: ActivityUseCase) {

    private val log: Logger = slf4j()

    @GetMapping("/publish")
    fun publishActivity(@RequestBody activityRequest: ActivityRequest): ActivityView {
        val activity = activityUseCase.publish(activityRequest)
        log.info("create activity with id ${activity.id}")
        return ActivityView.toActivityView(activity)
    }

    data class ActivityView(
        val id: String, val name: String, val startTime: LocalDateTime, val endTime: LocalDateTime
    ) {
        companion object {
            fun toActivityView(activity: Activity): ActivityView {
                return ActivityView(activity.id, activity.name, activity.startTime, activity.endTime)
            }
        }
    }

}