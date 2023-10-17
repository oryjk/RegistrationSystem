package activity.adapter.output

import com.wangrui.registrationsystem.activity.adapter.output.ActivityRepository
import com.wangrui.registrationsystem.activity.domain.Activity
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
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class ActivityRepositoryTest @Autowired constructor(var activityRepository: ActivityRepository){
    @Test
    fun saveActivity_test() {
        activityRepository.saveActivity(Activity("xxx", "name_xxx", LocalDateTime.now(), LocalDateTime.now()))
        val activityOptional = activityRepository.queryById("xxx")
        Assertions.assertTrue(activityOptional.isPresent)
    }
}