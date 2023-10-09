package com.wangrui.registrationsystem.competition.adapter.output

import com.wangrui.registrationsystem.competition.adapter.output.jpa.entity.CompetitionEntity
import com.wangrui.registrationsystem.competition.adapter.output.jpa.repository.CompetitionRepository
import com.wangrui.registrationsystem.competition.application.port.output.CompetitionWritePort
import com.wangrui.registrationsystem.competition.domain.Competition
import org.springframework.stereotype.Service

/**
 * Created on 2023/3/7 23:31.
 * @author wangrui
 * @since 0.0.1
 */
@Service
class CompetitionWriteAdapter(val competitionRepository: CompetitionRepository): CompetitionWritePort {
    override fun saveCompetition(competition: Competition): Competition {
        return competitionRepository.save(CompetitionEntity.toCompetitionEntity(competition)).toCompetition()
    }
}