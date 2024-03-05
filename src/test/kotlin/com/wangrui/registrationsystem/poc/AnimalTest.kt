package com.wangrui.registrationsystem.poc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Created on 2024/2/26 22:13.
 * @author wangrui
 * @since 0.0.1
 */

class AnimalTest {

    interface Flyer {
        fun kind() = "flying flyer"
    }

    interface Animal {
        fun kind() = "animal kind"
    }

    class Bird() : Flyer, Animal {
        override fun kind() = super<Animal>.kind()

        val name:String by lazy { "hello" }
    }

    @Test
    fun kind_test() {
        val bird = Bird()
        Assertions.assertEquals("animal kind", bird.kind())
    }
}