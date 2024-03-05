package com.wangrui.registrationsystem.ticket.application.port.input

/**
 * Created on 2024/2/28 23:35.
 * @author wangrui
 * @since 0.0.1
 */

interface GeneralTicketUseCase {
    data class BlockInfo(val blockName: String, val inventory: Int, val price: Float)

    fun getLatestTicketInfo(url: String, token: String): List<BlockInfo>
}