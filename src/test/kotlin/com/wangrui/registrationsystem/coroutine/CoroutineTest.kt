package com.wangrui.registrationsystem.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeUnit

/**
 * Created on 2024/3/1 15:31.
 * @author wangrui
 * @since 0.0.1
 */

class CoroutineTest {

    @Test
    fun launchTest() {
        println("外面 ${Thread.currentThread().id}")
        GlobalScope.launch {
            for (i in 1..100) {
                println("里面 ${Thread.currentThread().id}")
            }
        }
        TimeUnit.SECONDS.sleep(1)
        println("外面2 ${Thread.currentThread().id}")
    }
}