package com.wangrui.registrationsystem.poc

import com.google.common.util.concurrent.ThreadFactoryBuilder
import com.wangrui.registrationsystem.common.slf4j
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.ReentrantReadWriteLock
import javax.print.attribute.IntegerSyntax
import kotlin.random.Random

/**
 * Created on 2023/10/26 15:18.
 * @author wangrui
 * @since 0.0.1
 */

class LockTest {
    private val log: Logger = slf4j()
    private val lock = ReentrantReadWriteLock()
    private val pool = ThreadPoolExecutor(
        8,
        8,
        60L,
        TimeUnit.SECONDS,
        LinkedBlockingQueue(),
        ThreadFactoryBuilder().setNameFormat("PortfolioDataReadServiceThreadPool").build()
    )

    /**
     * 这个测试是为了测试 { @link ReentrantReadWriteLock} 的行为，分为读锁和写锁，
     * 读锁的行为：读锁可以重复获取，并且可以同时锁定，读锁锁定后，执行写锁的锁定
     * 写锁的行为：写锁在同一时刻，只能有一个可以锁定，其他的读锁，写锁都需要等待，等这个写锁释放之后才会允许其他的锁进行锁定
     */
    @Test
    fun test() {
        for (i in 1..100) {
            pool.execute {
                val number = Random.nextInt(0, 2)
                val name = if (number == 0) "读" else "写"
                val readLock = if (number == 0) lock.readLock() else lock.writeLock()
                log.info("获取了${name}锁，准备加锁 ${Thread.currentThread().id}")
                readLock.lock()
                log.info("${name}锁，已经锁住了 ${Thread.currentThread().id}")
                TimeUnit.SECONDS.sleep(3)
                log.info("释放了${name}锁 ${Thread.currentThread().id}")
                readLock.unlock()

            }
        }

        TimeUnit.SECONDS.sleep(100)
    }

    /**
     * 主要是理解同一个线程可以重复的获取到同一把锁，即使之前已经获取了写锁，也可以在获取读锁，并且进行锁定
     */
    @Test
    fun nestdTest() {
        writeLockCode();
        Assertions.assertTrue(true)
    }

    private fun writeLockCode() {
        val writeLock = lock.writeLock()
        writeLock.lock()
        log.info("writeLock ^^^^^^")
        readLockCode()
        TimeUnit.SECONDS.sleep(3)
        writeLock.unlock()
        log.info("unLock writeLock ^^^^^^")
    }

    private fun readLockCode() {
        val readLock = lock.readLock()
        readLock.lock()
        log.info("readLockCode ^^^^^^")
        readLock.unlock()
        log.info("unLock readLockCode ^^^^^^")
    }

    @Test
    fun typeTest() {
        data class Fund(val code: String)

        val fund = Fund("daily_yield")
        val type = fund::class.java.genericSuperclass
        Assertions.assertEquals("java.lang.Object", type.typeName)

        val listOfFund = listOf(fund)
        val listType = listOfFund::class.java.genericSuperclass
        Assertions.assertEquals("java.util.AbstractList<E>", listType.typeName)
        checkType<Int, Long>("20")
    }

    inline fun <reified T, reified T1> checkType(obj: Any) {
        when (obj) {
            is Long -> println("Object is type ${T1::class.simpleName}")
            is Int -> println("Object is type ${T::class.simpleName}")
            else -> println("啥也不是")
        }
    }

    interface Flyer {
        val height: Long
    }

    class Bird(name: String) : Flyer {
        val name1: String by lazy {
            "hello"
        }
        lateinit var age: String
        override val height: Long
            get() = TODO("Not yet implemented")

        fun say() {
            age = "wahaha"
        }

    }

    @Test
    fun bird_test() {
        val bird = Bird("hello")
        bird.say()
        println(bird.age)
    }

}