package com.wangrui.registrationsystem.grouping.domain

data class GroupingResult(val competitionId: String, val eachGrouping: List<EachGrouping>)

data class EachGrouping(val competitionId: String, val groupId: Int, val groupMember: GroupMember)

data class GroupMember(val participantId: List<String>)
