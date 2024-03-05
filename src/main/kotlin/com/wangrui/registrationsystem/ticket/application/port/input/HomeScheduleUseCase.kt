package com.wangrui.registrationsystem.ticket.application.port.input

import java.time.LocalDate

/**
 * Created on 2024/2/29 12:04.
 * @author wangrui
 * @since 0.0.1
 */

interface HomeScheduleUseCase {
    data class Schedule(
        val date: LocalDate,
        val hour: Int,
        val minute: Int,
        val homeName: String,
        val awayName: String,
        val round: Int
    )

    fun queryAll(): List<Schedule>
}