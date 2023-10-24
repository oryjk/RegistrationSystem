package com.wangrui.registrationsystem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RegistrationSystemApplicationTests {

    @Test
    fun contextLoads() {
        val company = Company()
        Assertions.assertTrue(true)
    }

    class Person {
        val name = true
        val age = true
    }

    @Test
    fun when_test() {
        val person = Person()
        when {
            person.age -> println("age")
            person.name -> println("name")
        }
    }

    @Test
    fun label_test() {
        loop@ for (i in listOf(1, 3, 5, 7, 9)) {
            println("i =  $i")
            for (j in listOf(2, 4, 6, 8)) {
                println("j = $j")
                if (j == 4) {
                    continue@loop

                }
            }
        }

        fun foo() {
            listOf(1, 2, 3, 4, 5).forEach {
                if (it == 3) return@forEach // local return to the caller of the lambda - the forEach loop
                println(it)
            }
            print(" done with implicit label")
        }
        foo()
        println("------------------------------")
        fun foo1() {
            run loop@{
                listOf(1, 2, 3, 4, 5).forEach {
                    if (it == 3) return@loop // non-local return from the lambda passed to run
                    println(it)
                }
            }
            print(" done with nested loop")
        }
        foo1()

    }


}
