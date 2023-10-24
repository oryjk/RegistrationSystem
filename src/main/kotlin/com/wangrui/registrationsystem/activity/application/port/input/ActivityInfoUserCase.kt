package com.wangrui.registrationsystem.activity.application.port.input

import com.wangrui.registrationsystem.activity.domain.ActivityInfo

interface ActivityInfoUserCase {
    fun create(activityInfo: ActivityInfo)
}