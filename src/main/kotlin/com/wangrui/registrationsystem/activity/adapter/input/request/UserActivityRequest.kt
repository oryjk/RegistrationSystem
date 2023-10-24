package com.wangrui.registrationsystem.activity.adapter.input.request

import com.wangrui.registrationsystem.activity.domain.Stand
import com.wangrui.registrationsystem.activity.domain.UserActivity

data class UserActivityRequest(
    val userId: String,
    val activityId: String,
    val stand: Int,
    val paid: Boolean
) {
    companion object {
        fun toUserActivity(userActivityRequest: UserActivityRequest): UserActivity {
            return UserActivity(
                userActivityRequest.userId,
                userActivityRequest.activityId,
                Stand.toStand(userActivityRequest.stand),
                userActivityRequest.paid
            )
        }
    }
}
