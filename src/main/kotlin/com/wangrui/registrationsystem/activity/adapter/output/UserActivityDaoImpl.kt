package com.wangrui.registrationsystem.activity.adapter.output

import com.wangrui.registrationsystem.activity.application.port.output.UserActivityDao
import com.wangrui.registrationsystem.activity.domain.UserActivity
import org.springframework.stereotype.Service

@Service
class UserActivityDaoImpl(val userActivityRepository: UserActivityRepository) : UserActivityDao {
    override fun save(userActivity: UserActivity) {
        userActivityRepository.save(UserActivityEntity.toUserActivityEntity(userActivity))
    }

    override fun findActivityByUserId(userId: String): List<UserActivity> {
        val userActivityEntities: List<UserActivityEntity> = userActivityRepository.findByIdUserId(userId)
        return userActivityEntities.map { UserActivityEntity.toUserActivity(it) }
    }
}