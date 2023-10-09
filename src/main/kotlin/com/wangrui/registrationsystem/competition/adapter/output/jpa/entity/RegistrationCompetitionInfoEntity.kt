package com.wangrui.registrationsystem.competition.adapter.output.jpa.entity

import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table
open class RegistrationCompetitionInfoEntity {
    @EmbeddedId
    open val id: RegistrationCompetitionInfoEntityPK? = null
}


@Embeddable
open class RegistrationCompetitionInfoEntityPK : Serializable {
    open var competitionId: String? = null
    open var userId: String? = null
}