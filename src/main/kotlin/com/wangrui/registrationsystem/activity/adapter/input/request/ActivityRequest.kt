package com.wangrui.registrationsystem.activity.adapter.input.request

import com.wangrui.registrationsystem.activity.domain.Activity
import java.time.LocalDateTime

/**
 * Created on 2023/10/13 14:47.
 * @author wangrui
 * @since 0.0.1
 */

data class ActivityRequest(
    val name: String,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime
) {
    companion object {
        fun toActivity(id: String, activityRequest: ActivityRequest): Activity {
            return Activity(id, activityRequest.name, activityRequest.startTime, activityRequest.endTime)
        }
    }
}
