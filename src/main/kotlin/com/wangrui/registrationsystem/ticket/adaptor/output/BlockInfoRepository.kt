package com.wangrui.registrationsystem.ticket.adaptor.output

import com.wangrui.registrationsystem.ticket.application.port.output.BlockInfoWriter
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created on 2024/3/1 14:35.
 * @author wangrui
 * @since 0.0.1
 */

@Repository
interface BlockInfoRepository : BlockInfoWriter, JpaRepository<BlockInfoWriter.BlockInfoEntity, Long> {
    override fun saveOne(blockInfoEntity: BlockInfoWriter.BlockInfoEntity) {
        save(blockInfoEntity)
    }
}