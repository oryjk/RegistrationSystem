package com.wangrui.registrationsystem.competition.application.port.input

import com.wangrui.registrationsystem.competition.domain.*

/**
 * Created on 2023/3/7 22:57.
 * @author wangrui
 * @since 0.0.1
 */

interface CreateCompetitionUseCase {
    fun createCompetition(competition: Competition): Competition
    fun getCompetition(id: CompetitionId): Competition

    fun getAllCompetition(): List<Competition>
    fun signIn(toSignIn: SignIn): SignInResult
    fun queryUserSignCompetitions(toUserSignCompetition: UserSignCompetition): List<UserSignCompetitionResult>
    fun queryUserSignCompetitions(signCompetition: SignCompetition): List<UserSignCompetitionResult>
}