package com.wangrui.registrationsystem.activity.adapter.output

import com.wangrui.registrationsystem.activity.domain.Activity
import com.wangrui.registrationsystem.activity.domain.Status
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime

/**
 * Created on 2023/10/17 23:14.
 * @author wangrui
 * @since 0.0.1
 */

@ExtendWith(SpringExtension::class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ActivityRepositoryIntegrationTest(@Autowired var activityRepository: ActivityRepository) {
    @Test
    fun saveActivity_test() {
        activityRepository.saveActivity(
            Activity(
                "xxx",
                "name_xxx",
                LocalDateTime.now(),
                LocalDateTime.now(),
                "封面的地址",
                Status.NOT_STARTED,
                "活动的地址"
            )
        )
        val activityOptional = activityRepository.queryById("xxx")
        Assertions.assertTrue(activityOptional.isPresent)
    }
}