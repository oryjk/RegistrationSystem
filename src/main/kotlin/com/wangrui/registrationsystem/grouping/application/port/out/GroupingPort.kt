package com.wangrui.registrationsystem.grouping.application.port.out

import com.wangrui.registrationsystem.grouping.domain.GroupingResult

interface GroupingPort {
    fun findByCompetitionId(id: String): GroupingResult

    fun doGroupWithCompetitionId(id: String): GroupingResult

    fun reDoGroupWithCompetitionId(id: String): GroupingResult

    fun deleteGroupByCompetitionId(id: String): Unit
}