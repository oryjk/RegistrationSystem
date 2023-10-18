package com.wangrui.registrationsystem.activity.application.service

import com.wangrui.registrationsystem.activity.domain.Activity
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime

/**
 * Created on 2023/10/17 23:48.
 * @author wangrui
 * @since 0.0.1
 */

@ExtendWith(SpringExtension::class)
//@DataJpaTest 不能同时标记，因为都使用了BootstrapWith，这个一个类只能有一个这样的申明
@SpringBootTest
class ActivityServiceTest {
    @Autowired
    private lateinit var ac: ActivityService

    @Test
    fun publish() {
        ac.publish(Activity("xxx", "name_xxx", LocalDateTime.now(), LocalDateTime.now()))
    }
}