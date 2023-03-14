package com.wangrui.registrationsystem.grouping.application.port.`in`

import com.wangrui.registrationsystem.grouping.domain.GroupingResult

interface GroupingUseCase {
    fun findByCompetitionId(id: String): GroupingResult

    fun doGroupWithCompetitionId(id: String): GroupingResult

    fun reDoGroupWithCompetitionId(id: String): GroupingResult

    fun deleteGroupByCompetitionId(id: String): Unit
}