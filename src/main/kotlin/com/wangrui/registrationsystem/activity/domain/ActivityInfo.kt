package com.wangrui.registrationsystem.activity.domain

import java.time.LocalDateTime

/**
 * Created on 2023/10/18 22:12.
 * @author wangrui
 * @since 0.0.1
 */

data class ActivityInfo(
    val activityId: String,
    val type: ActivityInfoType,
    val cancelDateTime: LocalDateTime,
    val description: String
)

enum class ActivityInfoType(val intValue: Int) {

    CLUB(0),//俱乐部性质
    INDIVIDUAL(1);//个人性质

    companion object {

        fun toActivityInfoType(intValue: Int): ActivityInfoType {
            return when (intValue) {
                0 -> CLUB
                1 -> INDIVIDUAL
                else -> throw IllegalArgumentException()
            }
        }
    }
}