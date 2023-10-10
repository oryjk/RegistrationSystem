package com.wangrui.registrationsystem.competition.application.port.input

import com.wangrui.registrationsystem.competition.domain.Competition
import com.wangrui.registrationsystem.competition.domain.CompetitionId

/**
 * Created on 2023/3/7 22:57.
 * @author wangrui
 * @since 0.0.1
 */

interface CreateCompetitionUseCase {
    fun createCompetition(competition: Competition): Competition
    fun getCompetition(id: CompetitionId): Competition

    fun getAllCompetition():List<Competition>
}