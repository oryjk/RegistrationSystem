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
    val endTime: LocalDateTime,
    val cover: String = "",
    val status: Status = Status.NOT_STARTED,
    val location: String = "",
)

enum class Status(val intValue: Int) {
    NOT_STARTED(0), IN_PROGRESS(1), ENDED(2);


    companion object {
        fun toStatus(intValue: Int): Status {
            return when (intValue) {
                0 -> NOT_STARTED
                1 -> IN_PROGRESS
                2 -> ENDED
                else -> throw IllegalArgumentException()
            }
        }
    }
}