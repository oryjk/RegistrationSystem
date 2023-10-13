package com.wangrui.registrationsystem.activity.domain

import java.time.LocalDateTime

/**
 * Created on 2023/10/13 17:17.
 * @author wangrui
 * @since 0.0.1
 */

data class Activity(
    val id: String,
    val name: String,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime
)