package com.wangrui.registrationsystem.activity.adapter.output

import com.wangrui.registrationsystem.activity.domain.UserActivity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserActivityRepository : JpaRepository<UserActivityEntity, String> {

}

data class UserActivityEntity(
    val userId: String,
    val activityId: String,
    val stand: Int,
    val paid: Int
) {
    companion object {
        fun toUserActivityEntity(userActivity: UserActivity): UserActivityEntity {
            return UserActivityEntity(
                userActivity.userId,
                userActivity.activityId,
                userActivity.stand.intValue,
                if (userActivity.paid) 1 else 0
            )
        }
    }
}