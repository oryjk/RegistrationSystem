package com.wangrui.registrationsystem.grouping.application.service

import com.wangrui.registrationsystem.competition.application.port.`in`.CreateCompetitionUseCase
import com.wangrui.registrationsystem.grouping.adapter.output.jpa.repository.EachGroupingRepository
import com.wangrui.registrationsystem.grouping.application.port.out.GroupingPort
import com.wangrui.registrationsystem.grouping.domain.EachGrouping
import com.wangrui.registrationsystem.grouping.domain.GroupMember
import com.wangrui.registrationsystem.grouping.domain.GroupingResult
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class GroupingDao(
    val groupingRepository: EachGroupingRepository,
    val competitionUseCase: CreateCompetitionUseCase
) : GroupingPort {
    override fun findByCompetitionId(id: String): GroupingResult {
        val eachGroupings = groupingRepository.findByIdCompetitionId(id).groupBy { it.id?.groupingId }.map { it ->
            val groupingId = it.key!!
            val userIds = it.value.map {
                it.id?.userId!!
            }
            EachGrouping(id, groupingId, GroupMember(userIds))
        }

        return GroupingResult(id, eachGroupings)
    }

    override fun doGroupWithCompetitionId(id: String): GroupingResult {
        competitionUseCase.
    }

    override fun reDoGroupWithCompetitionId(id: String): GroupingResult {
        TODO("Not yet implemented")
    }

    override fun deleteGroupByCompetitionId(id: String) {
        TODO("Not yet implemented")
    }
}