package com.wangrui.registrationsystem.activity.application.port.input

import com.wangrui.registrationsystem.activity.adapter.input.request.ActivityRequest
import com.wangrui.registrationsystem.activity.domain.Activity
import java.util.Optional

/**
 * Created on 2023/10/13 15:18.
 * @author wangrui
 * @since 0.0.1
 */

interface ActivityUseCase {
    fun publish(activity: Activity): Activity
    fun queryById(id: String): Optional<Activity>
}