package com.wangrui.registrationsystem.activity.adapter.output

import com.wangrui.registrationsystem.activity.application.port.output.ActivityDao
import com.wangrui.registrationsystem.activity.domain.Activity
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

data class ActivityEntity(
    val id: String, val name: String, val startTime: LocalDateTime, val endTime: LocalDateTime
) {
    companion object {
        fun toActivityEntity(activity: Activity): ActivityEntity {
            return ActivityEntity(activity.id, activity.name, activity.startTime, activity.endTime)
        }

        fun toActivity(activity: ActivityEntity): Activity {
            return Activity(activity.id, activity.name, activity.startTime, activity.endTime)
        }
    }
}