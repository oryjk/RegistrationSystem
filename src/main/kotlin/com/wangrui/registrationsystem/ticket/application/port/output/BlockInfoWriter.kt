package com.wangrui.registrationsystem.ticket.application.port.output

import com.wangrui.registrationsystem.ticket.application.port.input.GeneralTicketUseCase
import jakarta.persistence.*
import java.time.LocalDateTime

/**
 * Created on 2024/3/1 14:33.
 * @author wangrui
 * @since 0.0.1
 */

interface BlockInfoWriter {

    @Entity
    @Table(name = "rs_block_info")
    data class BlockInfoEntity(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
        val blockName: String,
        val inventory: Int,
        val price: Float,
        val time: LocalDateTime
    ) {
        companion object {
            fun toBlockInfoEntity(it: GeneralTicketUseCase.BlockInfo): BlockInfoEntity {
                return BlockInfoEntity(
                    blockName = it.blockName,
                    inventory = it.inventory,
                    price = it.price,
                    time = LocalDateTime.now()
                )
            }
        }
    }

    fun saveOne(blockInfoEntity: BlockInfoEntity)
}