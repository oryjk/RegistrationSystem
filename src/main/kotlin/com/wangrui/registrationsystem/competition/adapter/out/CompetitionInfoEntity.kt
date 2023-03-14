package com.wangrui.registrationsystem.competition.adapter.out

import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table
open class CompetitionInfoEntity {
    @EmbeddedId
    val competitionInfoPK: CompetitionInfoPK? = null
}


@Embeddable
open class CompetitionInfoPK : Serializable {
    open var competitionId: String? = null
    open var userId: String? = null
}