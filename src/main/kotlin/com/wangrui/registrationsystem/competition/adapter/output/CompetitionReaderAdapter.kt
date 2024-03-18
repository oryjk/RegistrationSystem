package com.wangrui.registrationsystem.competition.adapter.output

import com.wangrui.registrationsystem.competition.adapter.output.jpa.repository.CompetitionRepository
import com.wangrui.registrationsystem.competition.adapter.output.jpa.repository.SignInRepository
import com.wangrui.registrationsystem.competition.application.port.output.CompetitionReaderPort
import com.wangrui.registrationsystem.competition.domain.*
import org.springframework.stereotype.Service

/**
 * Created on 2023/3/7 23:13.
 * @author wangrui
 * @since 0.0.1
 */

@Service
class CompetitionReaderAdapter(
    val repository: CompetitionRepository,
    val signInRepository: SignInRepository
) : CompetitionReaderPort {
    override fun getCompetition(competitionId: CompetitionId): Competition {
        return repository.findById(competitionId)
            .orElseThrow { IllegalArgumentException("无法找到id为 $competitionId 的比赛信息") }.toCompetition()
    }

    override fun getAllCompetition(): List<Competition> {
        return repository.findAll().map { it.toCompetition() }
    }

    override fun queryUserSignCompetitions(userSignCompetition: UserSignCompetition): List<UserSignCompetitionResult> {
        val signInInfoEntities = signInRepository.findByUserId(userSignCompetition.userId)
        val result = signInInfoEntities.groupBy { it.id!!.competitionId }
            .mapValues { it ->
                it.value.maxByOrNull { it.id!!.signTime }
            }

        return result.values.map { it!!.toUserSignCompetitionResult() }.toList()
    }

    override fun queryUserSignCompetitions(userSignCompetition: SignCompetition): List<UserSignCompetitionResult> {
        val signInInfoEntities = signInRepository.findByCompetitionId(userSignCompetition.competitionId)
        val result = signInInfoEntities.groupBy { it.id!!.competitionId }
            .mapValues { it ->
                it.value.maxByOrNull { it.id!!.signTime }
            }

        return result.values.map { it!!.toUserSignCompetitionResult() }.toList()
    }
}