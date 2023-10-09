package com.wangrui.registrationsystem.competition.adapter.output.jpa.repository

import com.wangrui.registrationsystem.competition.adapter.output.jpa.entity.CompetitionEntity
import com.wangrui.registrationsystem.competition.domain.CompetitionId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created on 2023/3/7 23:15.
 * @author wangrui
 * @since 0.0.1
 */
@Repository
interface CompetitionRepository : JpaRepository<CompetitionEntity, CompetitionId> {}