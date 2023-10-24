package com.wangrui.registrationsystem.activity.application.service

import com.wangrui.registrationsystem.activity.application.port.input.ActivityInfoUserCase
import com.wangrui.registrationsystem.activity.application.port.output.ActivityInfoDao
import com.wangrui.registrationsystem.activity.domain.ActivityInfo
import com.wangrui.registrationsystem.common.slf4j
import org.slf4j.Logger
import org.springframework.stereotype.Service

@Service
class ActivityInfoService(val activityInfoDao: ActivityInfoDao) : ActivityInfoUserCase {
    private val log: Logger = slf4j()

    override fun create(activityInfo: ActivityInfo) {
        log.info("create activityInfo with activity id ${activityInfo.activityId}")
        activityInfoDao.saveActivityInfo(activityInfo)
    }
}