package com.wangrui.registrationsystem.ticket.application

import com.wangrui.registrationsystem.ticket.application.port.input.GeneralTicketUseCase
import com.wangrui.registrationsystem.ticket.application.port.output.BlockInfoWriter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

/**
 * Created on 2024/2/28 23:37.
 * @author wangrui
 * @since 0.0.1
 */

@Service
class GeneralTicketService(val blockInfoWriter: BlockInfoWriter) : GeneralTicketUseCase {
    private val logger = LoggerFactory.getLogger(javaClass)

    private val restTemplate = RestTemplate()
    override fun getLatestTicketInfo(url: String, token: String): List<GeneralTicketUseCase.BlockInfo> {
        val authorization = "Bearer $token"
        val httpHeaders = HttpHeaders()
        httpHeaders.contentType = MediaType.APPLICATION_JSON
        httpHeaders["User-Agent"] =
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3"
        httpHeaders.add("Authorization", authorization)
        httpHeaders.add("Referer", "https://servicewechat.com/wxffa42ecd6c0e693d/65/page-frame.html")

        val requestBody = "{\"id\":\"20\"}"

        val requestEntity = HttpEntity<Any>(requestBody, httpHeaders)

        val responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, TicketResponse::class.java)
        println("~~~~~~~~~~~~~~${responseEntity}~~~~~~~~~~~~~~~")
        val response = responseEntity.body!!
        logger.info("response.data size ${response.data.size}")


//       mock!!! return listOf(
//            GeneralTicketUseCase.BlockInfo("哈哈", 10, 150f),
//            GeneralTicketUseCase.BlockInfo("另外一个区", 20, 250f)
//        )


        return if ("立即购买" == response.btn_text) {
            logger.info("还有票，快抢 $response")
            val data = response.data[0]
            val blockInfos = data.list.map {
                GeneralTicketUseCase.BlockInfo(it.name, it.usable_count, it.price.toFloat())
            }
            GlobalScope.launch {
                blockInfos.forEach {
                    logger.info("存入数据库")
                    blockInfoWriter.saveOne(BlockInfoWriter.BlockInfoEntity.toBlockInfoEntity(it))
                }
            }
            return blockInfos
        } else {
            logger.info("没有票了 $response")
            emptyList()
        }


    }


    data class TicketResponse(
        val btn_status: Int,
        val btn_text: String,
        val code: Int,
        val data: List<Data>,
        val msg: String,
        val max_num: Int
    )

    data class Data(
        val usable_count: Int,
        val max_price: String,
        val min_price: String,
        val region: Int,
        val list: List<ListItem>,
        val name: String
    )

    data class ListItem(
        val usable_count: Int, val price: String, val estate: Int, val name: String, val id: Int
    )
}