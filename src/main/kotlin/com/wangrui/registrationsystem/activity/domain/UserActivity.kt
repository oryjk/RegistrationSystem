package com.wangrui.registrationsystem.activity.domain

data class UserActivity(
    val userId: String,
    val activityId: String,
    val stand: Stand,
    val paid: Boolean
)

enum class Stand(val intValue: Int) {
    NOT_PARTICIPATE(0),
    PARTICIPATE(1),
    PENDING(2);

    companion object {
        fun toStand(value: Int): Stand {
            return when (value) {
                0 -> NOT_PARTICIPATE
                1 -> PARTICIPATE
                2 -> PENDING
                else -> throw IllegalArgumentException()
            }
        }
    }
}
