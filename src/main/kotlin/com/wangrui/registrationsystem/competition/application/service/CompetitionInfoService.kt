package com.wangrui.registrationsystem.competition.application.service

import com.wangrui.registrationsystem.competition.application.port.input.CompetitionInfoUseCase
import com.wangrui.registrationsystem.competition.application.port.input.CreateCompetitionUseCase
import com.wangrui.registrationsystem.competition.application.port.output.CompetitionReaderPort
import com.wangrui.registrationsystem.competition.application.port.output.CompetitionWritePort
import com.wangrui.registrationsystem.competition.application.port.output.RegistrationCompetitionInfoPort
import com.wangrui.registrationsystem.competition.domain.Competition
import com.wangrui.registrationsystem.competition.domain.CompetitionId
import com.wangrui.registrationsystem.competition.domain.CompetitionInfo
import org.springframework.stereotype.Service

/**
 * Created on 2023/3/7 23:11.
 * @author wangrui
 * @since 0.0.1
 */

@Service
class CompetitionInfoService(
    val competitionReaderPort: CompetitionReaderPort,
    val competitionWritePort: CompetitionWritePort,
    val registrationCompetitionInfoPort: RegistrationCompetitionInfoPort
) : CompetitionInfoUseCase, CreateCompetitionUseCase {
    override fun getCompetitionInfo(id: CompetitionId): CompetitionInfo {
        val competition = competitionReaderPort.getCompetition(id)
        val participants = registrationCompetitionInfoPort.getParticipant(id)

        return CompetitionInfo(competition, participants)
    }

    override fun createCompetition(competition: Competition): Competition {
        return competitionWritePort.saveCompetition(competition)
    }

    override fun getCompetition(id: CompetitionId): Competition {
        return competitionReaderPort.getCompetition(id)
    }

    override fun getAllCompetition(): List<Competition> {
        return competitionReaderPort.getAllCompetition()
    }
}