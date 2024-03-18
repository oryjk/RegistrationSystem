package com.wangrui.registrationsystem.competition.domain

import java.time.LocalDateTime

/**
 * Created on 2024/3/17 11:33.
 * @author wangrui
 * @since 0.0.1
 */

data class SignIn(
    val id: Long, val userId: String, val action: Int
)

data class SignInResult(val status: Int)

data class UserSignCompetition(val userId: String)
data class SignCompetition(val competitionId: Long)
data class UserSignCompetitionResult(val id: Long, val userId: String, val signTime: LocalDateTime, val status: Int)