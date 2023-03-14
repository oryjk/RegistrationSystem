package com.wangrui.registrationsystem.grouping.adapter.output.jpa.repository

import com.wangrui.registrationsystem.grouping.adapter.output.jpa.entity.EachGroupingEntity
import com.wangrui.registrationsystem.grouping.adapter.output.jpa.entity.EachGroupingPK
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EachGroupingRepository : JpaRepository<EachGroupingEntity, EachGroupingPK> {
    fun findByIdCompetitionId(id: String): List<EachGroupingEntity>

}