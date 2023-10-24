package com.wangrui.registrationsystem.activity.adapter.input.request

import com.wangrui.registrationsystem.activity.application.port.input.ActivityInfoUserCase
import com.wangrui.registrationsystem.activity.domain.ActivityInfo
import com.wangrui.registrationsystem.activity.domain.ActivityInfoType
import java.time.LocalDateTime

data class ActivityInfoRequest(
    val activityId: String, val type: ActivityInfoType, val cancelDateTime: LocalDateTime, val description: String
) {
    companion object {
        fun toActivityInfo(activityInfoRequest: ActivityInfoRequest): ActivityInfo {
            return ActivityInfo(
                activityInfoRequest.activityId,
                activityInfoRequest.type,
                activityInfoRequest.cancelDateTime,
                activityInfoRequest.description
            )
        }
    }
}
