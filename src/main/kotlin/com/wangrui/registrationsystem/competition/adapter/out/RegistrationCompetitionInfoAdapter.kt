package com.wangrui.registrationsystem.competition.adapter.out

import com.wangrui.registrationsystem.competition.adapter.out.jpa.repository.RegistrationCompetitionInfoRepository
import com.wangrui.registrationsystem.competition.application.port.out.RegistrationCompetitionInfoPort
import com.wangrui.registrationsystem.competition.domain.CompetitionId
import com.wangrui.registrationsystem.user.domain.Participant
import org.springframework.stereotype.Service

/**
 * Created on 2023/3/15 19:03.
 * @author wangrui
 * @since 0.0.1
 */

@Service
class RegistrationCompetitionInfoAdapter(val registrationCompetitionInfoRepository: RegistrationCompetitionInfoRepository) :
    RegistrationCompetitionInfoPort {
    override fun getParticipant(competitionId: CompetitionId): List<Participant> {
        return registrationCompetitionInfoRepository.findByIdCompetitionId(competitionId).map {
            Participant(it.id!!.userId!!, "null", "null")
        }
    }
}