package com.wangrui.registrationsystem.configuration

import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


/**
 * Created on 2023/3/27 23:26.
 * @author wangrui
 * @since 0.0.1
 */

@Configuration
class JavaTimeModuleConfig {
    @Bean
    fun javaTimeModule(): Module {
        val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val module = JavaTimeModule()
        module.addSerializer(LocalDateTimeSerializer(dateTimeFormatter))
        module.addDeserializer(LocalDateTime::class.java, LocalDateTimeDeserializer(dateTimeFormatter))
        return module
    }
}