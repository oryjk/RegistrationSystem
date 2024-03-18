package com.wangrui.registrationsystem.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * Created on 2024/3/17 09:04.
 * @author wangrui
 * @since 0.0.1
 */

@Configuration
class MyWebConfigurer : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**") // 允许跨域的路径
            .allowedOrigins("*") // 允许跨域请求的域名
            .allowedMethods("GET", "POST", "PUT", "DELETE") // 允许的请求方法
            .allowedHeaders("*") // 允许的请求头
            .maxAge(3600); // 预检请求的缓存时间（秒）
    }
}