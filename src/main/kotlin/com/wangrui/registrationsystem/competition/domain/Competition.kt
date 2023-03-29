package com.wangrui.registrationsystem.competition.domain

import java.time.LocalDateTime

/**
 * Created on 2023/3/7 22:45.
 * 比赛领域的实体类
 * @author wangrui
 * @since 0.0.1
 */

class Competition(
    val id: CompetitionId?,
    val name: String,
    val gameType: GameType?,
    val gameDate: LocalDateTime?,
    val venue: String?,
    val contacts: String?,
    val competitionStatement: String?,
    val applicantsLimit: Int?
) {
    /**
     * 比赛类型，例如对内比赛，对外比赛
     */
    enum class GameType {
        Internal, External
    }


}
typealias CompetitionId = Long