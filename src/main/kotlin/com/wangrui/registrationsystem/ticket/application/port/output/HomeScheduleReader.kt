package com.wangrui.registrationsystem.ticket.application.port.output

import jakarta.persistence.*
import java.time.LocalDateTime

/**
 * Created on 2024/2/29 12:11.
 * @author wangrui
 * @since 0.0.1
 */

interface HomeScheduleReader {

    @Entity
    @Table(name = "rs_schedule")
    data class ScheduleDO(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val date: LocalDateTime,
        val homeName: String,
        val awayName: String,
        val round: Int
    )

    fun queryAll(): List<ScheduleDO>
}