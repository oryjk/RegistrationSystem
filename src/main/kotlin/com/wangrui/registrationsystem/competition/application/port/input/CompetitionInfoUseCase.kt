package com.wangrui.registrationsystem.competition.application.port.input

import com.wangrui.registrationsystem.competition.domain.CompetitionId
import com.wangrui.registrationsystem.competition.domain.CompetitionInfo

/**
 * Created on 2023/3/7 22:59.
 * @author wangrui
 * @since 0.0.1
 */

interface CompetitionInfoUseCase {
    fun getCompetitionInfo(id: CompetitionId): CompetitionInfo
}