package com.wangrui.registrationsystem.activity.application.service

import com.wangrui.registrationsystem.activity.application.port.input.ActivityUseCase
import com.wangrui.registrationsystem.activity.application.port.output.ActivityDao
import com.wangrui.registrationsystem.activity.domain.Activity
import com.wangrui.registrationsystem.common.slf4j
import org.slf4j.Logger
import org.springframework.stereotype.Service
import java.util.*

/**
 * Created on 2023/10/15 22:53.
 * @author wangrui
 * @since 0.0.1
 */

@Service
class ActivityService(val activityDao: ActivityDao) : ActivityUseCase {
    private val log: Logger = slf4j()
    override fun publish(activity: Activity): Activity {
        log.info("publish activity with id ${activity.id}")
        return activityDao.saveActivity(activity)
    }

    override fun queryById(id: String): Optional<Activity> {
        log.info("queryById activity with id $id")
        return activityDao.queryById(id)
    }
}