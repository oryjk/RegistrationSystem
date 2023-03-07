package com.wangrui.registrationsystem.competition.application.port.`in`

import com.wangrui.registrationsystem.competition.domain.Competition

/**
 * Created on 2023/3/7 22:57.
 * @author wangrui
 * @since 0.0.1
 */

interface CreateCompetitionUseCase {
    fun createCompetition(competition: Competition): Competition
}