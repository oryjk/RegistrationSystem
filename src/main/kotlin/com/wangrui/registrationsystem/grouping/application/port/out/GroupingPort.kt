package com.wangrui.registrationsystem.grouping.application.port.out

import com.wangrui.registrationsystem.competition.domain.CompetitionId
import com.wangrui.registrationsystem.grouping.domain.GroupingResult

interface GroupingPort {
    fun findByCompetitionId(id: CompetitionId): GroupingResult

    fun doGroupWithCompetitionId(id: CompetitionId, groupCount: Int): GroupingResult

    fun reDoGroupWithCompetitionId(id: String): GroupingResult

    fun deleteGroupByCompetitionId(id: String): Unit
}