package com.wangrui.registrationsystem.poc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LabelTest {

    fun hello(y: Int, x: (Int) -> String): String {
        return x(y)
    }

    @Test
    fun run_test() {
        val isNum = false
        val function = when {
            isNum -> te@{ x: Int -> return@te x.toString() }
            else -> tee@{ x: Int -> return@tee (x + 10).toString() }
        }
        val result = hello(10, function)
        val xxx = 20

        Assertions.assertEquals(xxx.toString(), result)

    }
}