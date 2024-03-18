package com.wangrui.registrationsystem.competition.application.port.output

import com.wangrui.registrationsystem.competition.domain.*

/**
 * Created on 2023/3/7 23:09.
 * @author wangrui
 * @since 0.0.1
 */

interface CompetitionReaderPort {
    fun getCompetition(competitionId: CompetitionId): Competition
    fun getAllCompetition(): List<Competition>
    fun queryUserSignCompetitions(userSignCompetition: UserSignCompetition): List<UserSignCompetitionResult>
    fun queryUserSignCompetitions(userSignCompetition: SignCompetition): List<UserSignCompetitionResult>
}