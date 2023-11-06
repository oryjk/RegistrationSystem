package com.wangrui.registrationsystem.activity.application.port.output

import com.wangrui.registrationsystem.activity.domain.UserActivity

interface UserActivityDao {
    fun save(userActivity: UserActivity)

    fun findActivityByUserId(userId:String):List<UserActivity>
}