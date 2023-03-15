package com.wangrui.registrationsystem.grouping.adapter.output.jpa.entity

import com.wangrui.registrationsystem.competition.domain.CompetitionId
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table
open class EachGroupingEntity(@EmbeddedId val id: EachGroupingPK)


@Embeddable
open class EachGroupingPK(val competitionId: CompetitionId, val groupingId: Int, val userId: String
) : Serializable