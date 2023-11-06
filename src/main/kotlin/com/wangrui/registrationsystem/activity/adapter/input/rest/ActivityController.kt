package com.wangrui.registrationsystem.activity.adapter.input.rest

import com.wangrui.registrationsystem.activity.adapter.input.request.ActivityRequest
import com.wangrui.registrationsystem.activity.application.port.input.ActivityUseCase
import com.wangrui.registrationsystem.activity.domain.Activity
import com.wangrui.registrationsystem.common.slf4j
import org.slf4j.Logger
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.ParallelFlux
import reactor.core.scheduler.Schedulers
import java.time.LocalDateTime
import java.util.*

/**
 * Created on 2023/10/13 14:48.
 * @author wangrui
 * @since 0.0.1
 */

@RestController
@RequestMapping("/api/activity")
class ActivityController(val activityUseCase: ActivityUseCase) {

    companion object {
        private val log: Logger = slf4j()
    }

    @PostMapping("/publish")
    fun publishActivity(@RequestBody activityRequest: ActivityRequest): ActivityView {
        val id = UUID.randomUUID().toString()
        val activity = activityUseCase.publish(ActivityRequest.toActivity(id, activityRequest))
        log.info("create activity with id ${activity.id}")
        return ActivityView.toActivityView(activity)
    }

    @GetMapping("/id")
    fun queryActivityById(@RequestParam id: String): ActivityView {
        val activity = activityUseCase.findById(id)
        val result = activity.map { ActivityView.toActivityView(it) }.orElse(ActivityView.NAN())
        log.info("create activity with id ${result.id}")
        return result
    }

    @GetMapping("/all")
    fun queryAll(): ParallelFlux<ActivityView> {
        val result = activityUseCase.findAll()
        return result.parallel().runOn(Schedulers.parallel()).map {
            log.info("Thread id ${Thread.currentThread().id}, logger hashcode ${log.hashCode()} ")
                ActivityView.toActivityView(it)
            }
    }

    data class ActivityView(
        val id: String?, val name: String?, val startTime: LocalDateTime?, val endTime: LocalDateTime?
    ) {
        companion object {
            fun toActivityView(activity: Activity): ActivityView {
                return ActivityView(activity.id, activity.name, activity.startTime, activity.endTime)
            }

            fun NAN(): ActivityView {
                return ActivityView("xxx", "xxx", null, null)
            }
        }
    }

}