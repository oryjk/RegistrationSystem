package com.wangrui.registrationsystem.competition.application.port.output

import com.wangrui.registrationsystem.competition.domain.CompetitionId
import com.wangrui.registrationsystem.user.domain.Participant

/**
 * Created on 2023/3/15 19:01.
 * @author wangrui
 * @since 0.0.1
 */

interface RegistrationCompetitionInfoPort {
    fun getParticipant(competitionId: CompetitionId): List<Participant>
}