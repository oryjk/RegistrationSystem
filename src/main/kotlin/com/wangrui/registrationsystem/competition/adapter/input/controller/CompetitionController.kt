package com.wangrui.registrationsystem.competition.adapter.input.controller

import com.wangrui.registrationsystem.competition.application.port.input.CreateCompetitionUseCase
import com.wangrui.registrationsystem.competition.domain.*
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

/**
 * Created on 2023/3/7 23:47.
 * @author wangrui
 * @since 0.0.1
 */

@RestController
@RequestMapping("/api/competition")
class CompetitionController(
    val competitionUseCase: CreateCompetitionUseCase
) {
    @PostMapping("/create")
    fun createCompetition(@RequestBody competitionRequest: CompetitionRequest): CompetitionView {
        val competition = competitionUseCase.createCompetition(competitionRequest.toCompetition())
        return CompetitionView.toCompetitionView(competition, 0, 0)
    }

    @GetMapping("/{id}")
    fun getCompetition(@PathVariable("id") id: CompetitionId): CompetitionView {
        val competition = competitionUseCase.getCompetition(id)
        val userSignCompetitions = competitionUseCase.queryUserSignCompetitions(SignCompetition(id))
        return CompetitionView.toCompetitionView(
            competition, userSignCompetitions.filter { it.status == 0 }.size, userSignCompetitions.size
        )
    }

    @GetMapping("/all")
    fun getAllCompetition(): List<CompetitionView> {
        val competitions = competitionUseCase.getAllCompetition()
        return competitions.map {
            val userSignCompetitions = competitionUseCase.queryUserSignCompetitions(SignCompetition(it.id!!))
            CompetitionView.toCompetitionView(
                it, userSignCompetitions.filter { it.status == 0 }.size, userSignCompetitions.size
            )
        }
    }

    @PostMapping("/signIn")
    fun signIn(@RequestBody signInRequest: SignInRequest): SignInView {
        val signInResult = competitionUseCase.signIn(signInRequest.toSignIn())
        return SignInView(signInResult.status)
    }

    @GetMapping("/all/signIn/{id}")
    fun getSignIn(@PathVariable("id") id: String): List<UserSignCompetitionResult> {
        return competitionUseCase.queryUserSignCompetitions(UserSignCompetition(id))
    }

    data class SignInRequest(
        val id: Long, val userId: String, val action: Int
    ) {
        fun toSignIn(): SignIn {
            return SignIn(
                this.id, this.userId, this.action
            )
        }
    }

    data class SignInView(val status: Int)
    data class CompetitionRequest(
        val name: String?,
        val gameType: Competition.GameType?,
        val gameDate: LocalDateTime?,
        val competitionSite: String?,
        val contacts: String?,
        val competitionStatement: String?,
        val applicantsLimit: Int?
    ) {
        fun toCompetition(): Competition {
            if (name == null) {
                throw IllegalArgumentException("比赛名称不能为空")
            }

            return Competition(
                null,
                name!!,
                gameType,
                gameDate,
                competitionSite,
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
        val applicantsLimit: Int?,
        /**
         * 确定能来参加的
         */
        val determine: Int?,
        /**
         * 已经表态的
         */
        val participated: Int?
    ) {
        companion object {
            fun toCompetitionView(competition: Competition, determine: Int, participated: Int): CompetitionView {
                return CompetitionView(
                    competition.id!!,
                    competition.name,
                    competition.gameType,
                    competition.gameDate,
                    competition.venue,
                    competition.contacts,
                    competition.competitionStatement,
                    competition.applicantsLimit,
                    determine,
                    participated
                )
            }
        }
    }
}