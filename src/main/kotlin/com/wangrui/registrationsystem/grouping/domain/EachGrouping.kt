package com.wangrui.registrationsystem.grouping.domain

import com.wangrui.registrationsystem.competition.domain.CompetitionId

data class GroupingResult(val competitionId: CompetitionId, val eachGrouping: List<EachGrouping>)

data class EachGrouping(val competitionId: CompetitionId, val groupId: Int, val groupMember: GroupMember)

data class GroupMember(val participantId: List<String>)
