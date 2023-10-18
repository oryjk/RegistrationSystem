package com.wangrui.registrationsystem.activity.adapter.output

import com.wangrui.registrationsystem.activity.application.port.output.ActivityDao
import com.wangrui.registrationsystem.activity.domain.Activity
import com.wangrui.registrationsystem.activity.domain.Status
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.util.*

/**
 * Created on 2023/10/15 23:01.
 * @author wangrui
 * @since 0.0.1
 */

@Repository
interface ActivityRepository : ActivityDao, JpaRepository<ActivityEntity, String> {
    override fun saveActivity(activity: Activity): Activity {
        val activityEntity = save(ActivityEntity.toActivityEntity(activity))
        return ActivityEntity.toActivity(activityEntity)
    }

    override fun queryById(id: String): Optional<Activity> {
        val entityOptional = findById(id)
        return entityOptional.map { ActivityEntity.toActivity(it) }
    }
}

@Table(name = "rs_activity")
@Entity
data class ActivityEntity(
    @Id val id: String,
    val name: String,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val cover: String,
    val status: Int,
    val location: String,
) {
    companion object {
        fun toActivityEntity(activity: Activity): ActivityEntity {
            return ActivityEntity(
                activity.id,
                activity.name,
                activity.startTime,
                activity.endTime,
                activity.cover,
                activity.status.intValue,
                activity.location
            )
        }

        fun toActivity(activity: ActivityEntity): Activity {
            return Activity(
                activity.id,
                activity.name,
                activity.startTime,
                activity.endTime,
                activity.cover,
                Status.toStatus(activity.status),
                activity.location
            )
        }
    }


}