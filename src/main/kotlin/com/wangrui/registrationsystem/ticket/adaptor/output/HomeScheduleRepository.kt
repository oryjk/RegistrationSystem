package com.wangrui.registrationsystem.ticket.adaptor.output

import com.wangrui.registrationsystem.ticket.application.port.output.HomeScheduleReader
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created on 2024/2/29 12:24.
 * @author wangrui
 * @since 0.0.1
 */

@Repository
interface HomeScheduleRepository : HomeScheduleReader, JpaRepository<HomeScheduleReader.ScheduleDO, Long> {

    override fun queryAll(): List<HomeScheduleReader.ScheduleDO> {
        return findAll()
    }
}