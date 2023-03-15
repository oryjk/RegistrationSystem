package com.wangrui.registrationsystem.competition.adapter.out.jpa.repository

import com.wangrui.registrationsystem.competition.adapter.out.jpa.entity.RegistrationCompetitionInfoEntity
import com.wangrui.registrationsystem.competition.adapter.out.jpa.entity.RegistrationCompetitionInfoEntityPK
import com.wangrui.registrationsystem.competition.domain.CompetitionId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created on 2023/3/15 18:58.
 * @author wangrui
 * @since 0.0.1
 */
@Repository
interface RegistrationCompetitionInfoRepository :
    JpaRepository<RegistrationCompetitionInfoEntity, RegistrationCompetitionInfoEntityPK> {
    fun findByIdCompetitionId(competitionId: CompetitionId): List<RegistrationCompetitionInfoEntity>
}