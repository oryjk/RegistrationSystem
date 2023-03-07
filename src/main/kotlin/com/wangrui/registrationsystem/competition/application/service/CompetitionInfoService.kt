package com.wangrui.registrationsystem.competition.application.service

import com.wangrui.registrationsystem.competition.application.port.`in`.CompetitionInfoUseCase
import com.wangrui.registrationsystem.competition.application.port.`in`.CreateCompetitionUseCase
import com.wangrui.registrationsystem.competition.application.port.out.CompetitionReaderPort
import com.wangrui.registrationsystem.competition.application.port.out.CompetitionWritePort
import com.wangrui.registrationsystem.competition.domain.Competition
import com.wangrui.registrationsystem.competition.domain.CompetitionId
import org.springframework.stereotype.Service

/**
 * Created on 2023/3/7 23:11.
 * @author wangrui
 * @since 0.0.1
 */

@Service
class CompetitionInfoService(
    val competitionReaderPort: CompetitionReaderPort, val competitionWritePort: CompetitionWritePort
) : CompetitionInfoUseCase, CreateCompetitionUseCase {
    override fun getCompetition(id: CompetitionId): Competition {
        return competitionReaderPort.getCompetition(id)
    }

    override fun createCompetition(competition: Competition): Competition {
        return competitionWritePort.saveCompetition(competition)
    }
}