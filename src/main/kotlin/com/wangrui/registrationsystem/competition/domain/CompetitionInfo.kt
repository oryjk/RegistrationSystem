package com.wangrui.registrationsystem.competition.domain

import com.wangrui.registrationsystem.user.domain.Participant

data class CompetitionInfo(val competition: Competition,val participants: List<Participant>)