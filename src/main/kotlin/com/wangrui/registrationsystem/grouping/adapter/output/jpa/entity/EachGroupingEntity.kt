package com.wangrui.registrationsystem.grouping.adapter.output.jpa.entity

import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table
open class EachGroupingEntity {
    @EmbeddedId
    open var id: EachGroupingPK? = null

}

@Embeddable
open class EachGroupingPK : Serializable {
    open var competitionId: String? = null
    open var groupingId: Int? = null
    open var userId: String? = null

}