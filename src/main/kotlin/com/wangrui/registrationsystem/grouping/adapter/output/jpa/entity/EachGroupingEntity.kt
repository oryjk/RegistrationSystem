package com.wangrui.registrationsystem.grouping.adapter.output.jpa.entity

import com.wangrui.registrationsystem.competition.domain.CompetitionId
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.io.Serializable

//如果不用all-open插件的话，jpa的entity需要这样写
//@Entity
//@Table
//open class EachGroupingEntity() {
//    @EmbeddedId
//    open lateinit var id: EachGroupingPK
//
//    constructor(id: EachGroupingPK) : this() {
//        this.id = id
//    }
//}

@Entity
@Table
class EachGroupingEntity(@EmbeddedId var id: EachGroupingPK? = null)


@Embeddable
class EachGroupingPK(
    var competitionId: CompetitionId, var groupingId: Int, var userId: String
) : Serializable