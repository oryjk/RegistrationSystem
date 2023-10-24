package com.wangrui.registrationsystem.activity.application.port.input

import com.wangrui.registrationsystem.activity.domain.UserActivity

interface UserActivityUseCase {
    fun register(userActivity: UserActivity)
}