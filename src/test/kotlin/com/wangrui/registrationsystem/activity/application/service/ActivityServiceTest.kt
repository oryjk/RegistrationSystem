package com.wangrui.registrationsystem.activity.application.service

import com.wangrui.registrationsystem.activity.domain.Activity
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime
import org.springframework.boot.test.context.SpringBootTest

/**
 * Created on 2023/10/17 23:48.
 * @author wangrui
 * @since 0.0.1
 */

@ExtendWith(SpringExtension::class)
@DataJpaTest
@SpringBootTest
class ActivityServiceTest {
    @Autowired
    private lateinit var ac: ActivityService

    @Test
    fun publish() {
        ac.publish(Activity("xxx", "name_xxx", LocalDateTime.now(), LocalDateTime.now()))
    }
}