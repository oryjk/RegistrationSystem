package com.wangrui.registrationsystem.activity.adapter.application.input

import com.wangrui.registrationsystem.activity.adapter.input.request.ActivityRequest
import com.wangrui.registrationsystem.activity.domain.Activity

/**
 * Created on 2023/10/13 15:18.
 * @author wangrui
 * @since 0.0.1
 */

interface ActivityUseCase {
    fun publish(activityRequest: ActivityRequest): Activity
    fun queryById(id: String): Activity
}