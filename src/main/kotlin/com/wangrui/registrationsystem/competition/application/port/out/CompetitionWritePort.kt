package com.wangrui.registrationsystem.competition.application.port.out

import com.wangrui.registrationsystem.competition.domain.Competition

/**
 * Created on 2023/3/7 23:09.
 * @author wangrui
 * @since 0.0.1
 */

interface CompetitionWritePort {
    fun saveCompetition(competition: Competition):Competition
}