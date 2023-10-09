package com.wangrui.registrationsystem.grouping.application.service

import com.google.common.collect.Lists
import com.wangrui.registrationsystem.competition.application.port.input.CompetitionInfoUseCase
import com.wangrui.registrationsystem.competition.application.port.input.CreateCompetitionUseCase
import com.wangrui.registrationsystem.competition.domain.CompetitionId
import com.wangrui.registrationsystem.grouping.adapter.output.jpa.entity.EachGroupingEntity
import com.wangrui.registrationsystem.grouping.adapter.output.jpa.entity.EachGroupingPK
import com.wangrui.registrationsystem.grouping.adapter.output.jpa.repository.EachGroupingRepository
import com.wangrui.registrationsystem.grouping.application.port.out.GroupingPort
import com.wangrui.registrationsystem.grouping.domain.EachGrouping
import com.wangrui.registrationsystem.grouping.domain.GroupMember
import com.wangrui.registrationsystem.grouping.domain.GroupingResult
import org.springframework.stereotype.Service

@Service
class GroupingDao(
    val groupingRepository: EachGroupingRepository,
    val competitionUseCase: CreateCompetitionUseCase,
    val competitionInfoUseCase: CompetitionInfoUseCase
) : GroupingPort {
    override fun findByCompetitionId(id: CompetitionId): GroupingResult {
        val eachGroupings = groupingRepository.findByIdCompetitionId(id).groupBy { it.id?.groupingId }.map { it ->
            val groupingId = it.key
            val userIds = it.value.map {
                it.id?.userId!!
            }
            EachGrouping(id, groupingId!!, GroupMember(userIds))
        }

        return GroupingResult(id, eachGroupings)
    }

    override fun doGroupWithCompetitionId(id: CompetitionId, groupCount: Int): GroupingResult {
        val competitionInfo = competitionInfoUseCase.getCompetitionInfo(id)
        val participants = ArrayList(competitionInfo.participants)
        if (participants.size < groupCount) {
            throw IllegalArgumentException("报名人数小于分组个数，无法进行分组")
        }
        if (participants.size % groupCount != 0) {
            throw IllegalArgumentException("报名人数无法整除分组")
        }

        participants.shuffle()
        val partition = Lists.partition(participants, groupCount)
        for (i in 1..groupCount) {
            partition.map { it ->
                val eachGroupingEntities = it.map {
                    val userId = it.id
                    EachGroupingEntity(EachGroupingPK(id, i, userId))
                }
                groupingRepository.saveAll(eachGroupingEntities)
            }
        }

        return findByCompetitionId(id)
    }

    override fun reDoGroupWithCompetitionId(id: String): GroupingResult {
        TODO("Not yet implemented")
    }

    override fun deleteGroupByCompetitionId(id: String) {
        TODO("Not yet implemented")
    }
}