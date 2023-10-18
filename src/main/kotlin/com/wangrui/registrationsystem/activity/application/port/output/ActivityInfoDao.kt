package com.wangrui.registrationsystem.activity.application.port.output

import com.wangrui.registrationsystem.activity.domain.ActivityInfo
import java.util.*

/**
 * Created on 2023/10/18 22:18.
 * @author wangrui
 * @since 0.0.1
 */

interface ActivityInfoDao {
    fun saveActivityInfo(activityInfo: ActivityInfo): ActivityInfo

    fun queryById(id: String): Optional<ActivityInfo>
}