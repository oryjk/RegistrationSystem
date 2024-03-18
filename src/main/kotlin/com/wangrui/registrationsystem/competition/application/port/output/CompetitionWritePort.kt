package com.wangrui.registrationsystem.competition.application.port.output

import com.wangrui.registrationsystem.competition.domain.Competition
import com.wangrui.registrationsystem.competition.domain.SignIn
import com.wangrui.registrationsystem.competition.domain.SignInResult

/**
 * Created on 2023/3/7 23:09.
 * @author wangrui
 * @since 0.0.1
 */

interface CompetitionWritePort {
    fun saveCompetition(competition: Competition):Competition

    fun signIn(signIn: SignIn):SignInResult
}