package com.wangrui.registrationsystem.activity.application.service

import com.wangrui.registrationsystem.activity.application.port.input.UserActivityUseCase
import com.wangrui.registrationsystem.activity.application.port.output.UserActivityDao
import com.wangrui.registrationsystem.activity.domain.UserActivity
import org.springframework.stereotype.Service

@Service
class UserActivityService(val userActivityDao: UserActivityDao) : UserActivityUseCase {
    override fun register(userActivity: UserActivity) {
        userActivityDao.save(userActivity)
    }
}