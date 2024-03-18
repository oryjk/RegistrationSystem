package com.wangrui.registrationsystem.poc.expect

/**
 * Created on 2024/3/5 15:45.
 * @author wangrui
 * @since 0.0.1
 */

class ExpectTest {
    fun sss(name: Animal = Dog()) {

    }
}

interface Animal {
    fun say(): Unit
}

class Dog : Animal {
    override fun say() {
        TODO("Not yet implemented")
    }
}

class Hell {
    fun say() {
        println("ahah")
    }
}