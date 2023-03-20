package com.wangrui.registrationsystem.competition.adapter.out.jpa.entity

import com.wangrui.registrationsystem.competition.domain.Competition
import com.wangrui.registrationsystem.competition.domain.CompetitionId
import jakarta.persistence.*
import java.time.LocalDateTime

/**
 * Created on 2023/3/7 23:16.
 * @author wangrui
 * @since 0.0.1
 */
@Entity
@Table(name = "competition")
open class CompetitionEntity(
    private val name: String?,
    private val gameType: Competition.GameType?,
    private val gameDate: LocalDateTime?,
    private val venue: String?,
    private val contacts: String?,
    private val competitionStatement: String?,
    private val applicantsLimit: Int?,
    private val createTime: LocalDateTime?,
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) @Column(
        name = "id", nullable = false
    ) private val id: CompetitionId? = null,
) {


    fun toCompetition(): Competition {
        return Competition(id, name, gameType, gameDate, venue, contacts, competitionStatement, applicantsLimit)
    }

    companion object {
        fun toCompetitionEntity(competition: Competition): CompetitionEntity {
            return CompetitionEntity(
                competition.name,
                competition.gameType,
                competition.gameDate,
                competition.venue,
                competition.contacts,
                competition.competitionStatement,
                competition.applicantsLimit,
                LocalDateTime.now(),
                competition.id,
            )
        }
    }

}