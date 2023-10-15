package com.wangrui.registrationsystem.activity.application.port.output

import com.wangrui.registrationsystem.activity.domain.Activity
import java.util.Optional

/**
 * Created on 2023/10/15 22:59.
 * @author wangrui
 * @since 0.0.1
 */

interface ActivityDao {
    fun saveActivity(activity: Activity): Activity

    fun queryById(id: String): Optional<Activity>
}