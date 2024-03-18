package com.wangrui.registrationsystem.activity.adapter.input.request

import com.wangrui.registrationsystem.activity.domain.ActivityInfo
import com.wangrui.registrationsystem.activity.domain.ActivityInfoType
import java.time.LocalDateTime


/**
 * 表示层，活动信息
 */
data class ActivityInfoRequest(
    /**
     * 活动唯一标识
     */
    val activityId: String,
    /**
     * 活动的类型，是个人还是俱乐部
     */
    val type: ActivityInfoType,
    /**
     * 活动取消时间
     */
    val cancelDateTime: LocalDateTime,
    /**
     * 活动的描述信息
     */
    val description: String
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
