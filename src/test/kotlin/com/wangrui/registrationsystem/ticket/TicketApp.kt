package com.wangrui.registrationsystem.ticket

import org.slf4j.LoggerFactory
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit

/**
 * Created on 2024/2/27 23:55.
 * @author wangrui
 * @since 0.0.1
 */

object TicketApp {
    private val logger = LoggerFactory.getLogger(javaClass)
    private val url = "https://fccdn1.k4n.cc/fc/wx_api/v1/GroupTicket/inventoryStatus?lid2=116692"
    private val token =
        "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjExNjY5Miwib2lkIjoiMWYxMGI5OWJkODNiZTAxN2Q3NDE5MGM0MGYyNmJhMDgiLCJsaWQiOjAsInNpZGUiOiJ3eF9hcGkiLCJhdWQiOiIiLCJleHAiOjE3MDkxMTY5MjEsImlhdCI6MTcwOTA0NDkyMSwiaXNzIjoiIiwianRpIjoiNzRhZjU4OTczOGUyNTY0YmM0MDgwNmE5YjZmZjc0ZTEiLCJuYmYiOjE3MDkwNDQ5MjEsInN1YiI6IiJ9.kyEyLNzYrv4fSjrOtM2alulsto3dcsmKTMlyBC3fVFk"

    @JvmStatic
    fun main(args: Array<String>) {
        System.setProperty("org.springframework.web.client.RestTemplate", "INFO");
        loopTest()
    }

    fun loopTest() {
        while (true) {
            ticket(url, token)
            TimeUnit.SECONDS.sleep(1)
        }
    }

    private fun ticket(url: String, token: String) {
        val restTemplate = RestTemplate()

        val authorization = "Bearer $token"
        val httpHeaders = HttpHeaders()
        httpHeaders.contentType = MediaType.APPLICATION_JSON
        httpHeaders["User-Agent"] =
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3"
        httpHeaders.add("Authorization", authorization)
        val requestEntity = HttpEntity<Any>(httpHeaders)

//        val response = restTemplate.postForObject(url, request, TicketResponse::class.java)
        val response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, TicketResponse::class.java).body
        if ("success" == response?.msg) {
            val ticketDataResponse = response.data
            logger.info("成功发送请求，当前时间 ${LocalDateTime.now()}, 返回的条数为 ${ticketDataResponse.list.size}")
            ticketDataResponse.list
                .filter { it.inventory != 0 }
                .forEach {
                    logger.info("~~~~~当前类别 ${it.name} 剩余票数 ${it.inventory} 价格为 ${it.price}~~~~~")
                }

        }

    }

    data class TicketResponse(val code: Int, val data: TicketDataResponse, val msg: String)

    data class TicketDataResponse(
        val text: String, val status: Int, val list: List<TicketItem>
    )

    data class TicketItem(
        val id: Int,
        val inventory: Int,
        val car_img: String,
        val price: String,
        val old_price: String,
        val name: String,
        val details: String,
        val member_num: Int
    )
}