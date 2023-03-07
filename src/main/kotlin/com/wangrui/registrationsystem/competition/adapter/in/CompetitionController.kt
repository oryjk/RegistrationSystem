package com.wangrui.registrationsystem.competition.adapter.`in`

import com.wangrui.registrationsystem.competition.application.port.`in`.CompetitionInfoUseCase
import com.wangrui.registrationsystem.competition.application.port.`in`.CreateCompetitionUseCase
import com.wangrui.registrationsystem.competition.domain.Competition
import com.wangrui.registrationsystem.competition.domain.CompetitionId
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

/**
 * Created on 2023/3/7 23:47.
 * @author wangrui
 * @since 0.0.1
 */

@RestController
@RequestMapping("/api/competition")
class CompetitionController(
    val competitionUseCase: CreateCompetitionUseCase, val competitionInfoUseCase: CompetitionInfoUseCase
) {
    @PostMapping("/create")
    fun createCompetition(competitionRequest: CompetitionRequest): CompetitionView {
        val competition = competitionUseCase.createCompetition(competitionRequest.toCompetition())
        return CompetitionView.toCompetitionView(competition)
    }

    @PostMapping("/info")
    fun getCompetitionInfo(id: CompetitionId): CompetitionView {
        val competition = competitionInfoUseCase.getCompetition(id)
        return CompetitionView.toCompetitionView(competition)
    }

    data class CompetitionRequest(
        val name: String?,
        val gameType: Competition.GameType?,
        val gameDate: LocalDateTime?,
        val venue: String?,
        val contacts: String?,
        val competitionStatement: String?,
        val applicantsLimit: Int?
    ) {
        fun toCompetition(): Competition {
            return Competition(
                null,
                name,
                gameType,
                gameDate,
                venue,
                contacts,
                competitionStatement,
                applicantsLimit,
            )
        }
    }

    data class CompetitionView(
        val id: CompetitionId,
        val name: String?,
        val gameType: Competition.GameType?,
        val gameDate: LocalDateTime?,
        val venue: String?,
        val contacts: String?,
        val competitionStatement: String?,
        val applicantsLimit: Int?
    ) {
        companion object {
            fun toCompetitionView(competition: Competition): CompetitionView {
                return CompetitionView(
                    competition.id!!,
                    competition.name,
                    competition.gameType,
                    competition.gameDate,
                    competition.venue,
                    competition.contacts,
                    competition.competitionStatement,
                    competition.applicantsLimit,
                )
            }
        }
    }
}