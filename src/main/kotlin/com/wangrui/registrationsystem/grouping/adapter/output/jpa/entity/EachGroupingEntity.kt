package com.wangrui.registrationsystem.grouping.adapter.output.jpa.entity

import com.wangrui.registrationsystem.competition.domain.CompetitionId
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table
open class EachGroupingEntity(@EmbeddedId open val id: EachGroupingPK)


@Embeddable
open class EachGroupingPK(
     open val competitionId: CompetitionId, open val groupingId: Int, open val userId: String
) : Serializable