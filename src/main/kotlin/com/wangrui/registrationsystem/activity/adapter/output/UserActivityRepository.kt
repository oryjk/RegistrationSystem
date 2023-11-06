package com.wangrui.registrationsystem.activity.adapter.output

import com.wangrui.registrationsystem.activity.domain.Stand
import com.wangrui.registrationsystem.activity.domain.UserActivity
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.io.Serializable

@Repository
interface UserActivityRepository : JpaRepository<UserActivityEntity, UserActivityKey> {
    fun findByIdUserId(userId: String): List<UserActivityEntity>

}

@Entity
@Table(name = "rs_user_activity")
data class UserActivityEntity(
    @EmbeddedId val id: UserActivityKey,
    val stand: Int,
    val paid: Int
) {
    companion object {
        fun toUserActivityEntity(userActivity: UserActivity): UserActivityEntity {
            return UserActivityEntity(
                UserActivityKey(userActivity.userId, userActivity.activityId),
                userActivity.stand.intValue,
                if (userActivity.paid) 1 else 0
            )
        }

        fun toUserActivity(userActivity: UserActivityEntity): UserActivity {
            return UserActivity(
                userActivity.id.userId,
                userActivity.id.activityId,
                Stand.toStand(userActivity.stand),
                if (userActivity.paid == 1) true else false
            )
        }
    }
}

@Embeddable
data class UserActivityKey(val userId: String, val activityId: String) : Serializable