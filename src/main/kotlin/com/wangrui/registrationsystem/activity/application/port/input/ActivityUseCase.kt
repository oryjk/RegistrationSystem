package com.wangrui.registrationsystem.activity.application.port.input

import com.wangrui.registrationsystem.activity.domain.Activity
import reactor.core.publisher.Flux
import java.util.*

/**
 * Created on 2023/10/13 15:18.
 * @author wangrui
 * @since 0.0.1
 */

interface ActivityUseCase {
    fun publish(activity: Activity): Activity
    fun findById(id: String): Optional<Activity>

    fun findAll(): Flux<Activity>
}