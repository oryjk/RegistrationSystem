package com.wangrui.registrationsystem.ticket.adaptor.input.rest

import com.wangrui.registrationsystem.ticket.application.port.input.GeneralTicketUseCase
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created on 2024/2/28 23:27.
 * @author wangrui
 * @since 0.0.1
 */

@RestController
@RequestMapping("/api/general-ticket")
@CrossOrigin
class GeneralTicketController(val generalTicketUseCase: GeneralTicketUseCase) {

    private val logger = LoggerFactory.getLogger(javaClass)
    private val url = "https://fccdn1.k4n.cc/fc/wx_api/v1/MatchCon/getBillRegion?lid2=116692"
    private val token =
        "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjExNjY5Miwib2lkIjoiMWYxMGI5OWJkODNiZTAxN2Q3NDE5MGM0MGYyNmJhMDgiLCJsaWQiOjAsInNpZGUiOiJ3eF9hcGkiLCJhdWQiOiIiLCJleHAiOjE3MDkzNjE1MjQsImlhdCI6MTcwOTI4OTUyNCwiaXNzIjoiIiwianRpIjoiNmQ1YjFkYzMxYzA1MTExMmJmOTMzYzJjYWU2NTc5ODAiLCJuYmYiOjE3MDkyODk1MjQsInN1YiI6IiJ9.YxaDJ_4QPYjXvp1HsnxcUshHbfhF1pq8dN0aJDFSDLI"


    @GetMapping("/latestTicketInfo")
    fun latestTicketInfo(): HttpResp {
        return HttpResp(generalTicketUseCase.getLatestTicketInfo(url, token))
    }

    data class HttpResp(val blockInfos: List<GeneralTicketUseCase.BlockInfo>)


}