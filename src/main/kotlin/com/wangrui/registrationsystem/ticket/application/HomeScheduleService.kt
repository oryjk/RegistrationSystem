package com.wangrui.registrationsystem.ticket.application

import com.wangrui.registrationsystem.ticket.application.port.input.HomeScheduleUseCase
import com.wangrui.registrationsystem.ticket.application.port.output.HomeScheduleReader
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

/**
 * Created on 2024/2/29 12:06.
 * @author wangrui
 * @since 0.0.1
 */

@Service
class HomeScheduleService(val homeScheduleReader: HomeScheduleReader) : HomeScheduleUseCase {
    private val logger = LoggerFactory.getLogger(javaClass)
    override fun queryAll(): List<HomeScheduleUseCase.Schedule> {
        val scheduleDOList = homeScheduleReader.queryAll()
        logger.info("scheduleDOList size ${scheduleDOList.size}")

        return scheduleDOList.map { scheduleDO ->
            val localDate = scheduleDO.date.toLocalDate()
            val localTime = scheduleDO.date.toLocalTime()
            HomeScheduleUseCase.Schedule(
                localDate, localTime.hour, localTime.minute, scheduleDO.homeName, scheduleDO.awayName, scheduleDO.round
            )
        }
    }
}