package com.wangrui.registrationsystem.poc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Created on 2024/2/18 20:57.
 * @author wangrui
 * @since 0.0.1
 */

class ExpressTest {

    @Test
    fun e() {
        val e = { x: Int -> x + 1 }
        println(e(1))
    }

    @Test
    fun carr() {
        fun x(num: Int, block: (Int) -> Int): Int {
            println("num is $num")
            return block(num)
        }

        Assertions.assertEquals(20, x(10) { x -> x + 10 })
        Assertions.assertEquals(20, fun(x: Int): Int { return x + 10 }(10))
        Assertions.assertEquals(20, { x: Int -> x + 10 }(10))
        Assertions.assertEquals(20, x(10) { x: Int -> x + 10 })

        val y = 10
        val resu = if (y < 10) 10 else 100
        Assertions.assertEquals(100, resu)
    }

    @Test
    fun infix_test(){
        class Person{
             infix fun called(name:String){
                println("My name is $name")
            }
        }

        val person = Person()
        person called "hello"
    }
}