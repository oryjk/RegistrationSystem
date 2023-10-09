package com.wangrui.registrationsystem.competition.application.port.output

import com.wangrui.registrationsystem.competition.domain.Competition
import com.wangrui.registrationsystem.competition.domain.CompetitionId

/**
 * Created on 2023/3/7 23:09.
 * @author wangrui
 * @since 0.0.1
 */

interface CompetitionReaderPort {
    fun getCompetition(competitionId: CompetitionId): Competition
    fun getAllCompetition(): List<Competition>
}