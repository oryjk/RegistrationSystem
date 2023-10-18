package com.wangrui.registrationsystem.activity.adapter.output

import com.wangrui.registrationsystem.activity.application.port.output.ActivityInfoDao
import com.wangrui.registrationsystem.activity.domain.ActivityInfo
import com.wangrui.registrationsystem.activity.domain.ActivityInfoType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.util.*

/**
 * Created on 2023/10/18 22:17.
 * @author wangrui
 * @since 0.0.1
 */

@Repository
interface ActivityInfoRepository : ActivityInfoDao, JpaRepository<ActivityInfoEntity, String> {
    override fun saveActivityInfo(activityInfo: ActivityInfo): ActivityInfo {
        val result = save(ActivityInfoEntity.toActivityInfoEntity(activityInfo))
        return ActivityInfoEntity.toActivityInfo(result)
    }

    override fun queryById(id: String): Optional<ActivityInfo> {
        return findById(id).map { ActivityInfoEntity.toActivityInfo(it) }
    }
}

@Entity
@Table(name = "rs_activity_info")
data class ActivityInfoEntity(
    @Id @Column(name = "activity_id") val activityId: String,
    val type: Int,
    val cancelDateTime: LocalDateTime,
    val description: String
) {
    companion object {
        fun toActivityInfoEntity(activityInfo: ActivityInfo): ActivityInfoEntity {
            return ActivityInfoEntity(
                activityInfo.activityId,
                activityInfo.type.intValue,
                activityInfo.cancelDateTime,
                activityInfo.description
            )
        }

        fun toActivityInfo(activityInfo: ActivityInfoEntity): ActivityInfo {
            return ActivityInfo(
                activityInfo.activityId,
                ActivityInfoType.toActivityInfoType(activityInfo.type),
                activityInfo.cancelDateTime,
                activityInfo.description
            )
        }
    }
}