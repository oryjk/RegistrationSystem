package com.wangrui.registrationsystem.activity.adapter.input.request

import com.fasterxml.jackson.annotation.JsonFormat
import com.wangrui.registrationsystem.activity.domain.Activity
import com.wangrui.registrationsystem.activity.domain.Status
import java.time.LocalDateTime

/**
 * Created on 2023/10/13 14:47.
 * @author wangrui
 * @since 0.0.1
 */

data class ActivityRequest(
    /**
     * 活动的名称
     */
    val name: String,
    /**
     * 活动的开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm") val startTime: LocalDateTime,
    /**
     * 活动的结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm") val endTime: LocalDateTime,
    /**
     * 活动的图片
     */
    val cover: String = "",
    /**
     * 活动地点
     */
    val location: String = "",
) {
    companion object {
        fun toActivity(id: String, activityRequest: ActivityRequest): Activity {
            return Activity(
                id,
                activityRequest.name,
                activityRequest.startTime,
                activityRequest.endTime,
                activityRequest.cover,
                Status.NOT_STARTED,
                activityRequest.location
            )
        }
    }
}
