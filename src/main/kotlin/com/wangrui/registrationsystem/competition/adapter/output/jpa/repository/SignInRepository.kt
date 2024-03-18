package com.wangrui.registrationsystem.competition.adapter.output.jpa.repository

import com.wangrui.registrationsystem.competition.domain.UserSignCompetitionResult
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.io.Serializable
import java.time.LocalDateTime

/**
 * Created on 2024/3/17 11:40.
 * @author wangrui
 * @since 0.0.1
 */

@Repository
interface SignInRepository : JpaRepository<SignInInfoEntity, SignInId> {

    @Query("SELECT s FROM SignInInfoEntity s WHERE s.id.userId = :userId")
    fun findByUserId(@Param("userId") userId: String): List<SignInInfoEntity>

    @Query("SELECT s FROM SignInInfoEntity s WHERE s.id.competitionId = :competitionId")
    fun findByCompetitionId(@Param("competitionId") competitionId: Long): List<SignInInfoEntity>
}

@Entity
@Table(name = "rs_sign_in_info")
data class SignInInfoEntity(
    @EmbeddedId val id: SignInId? = null,
    val status: Int,
) {
    fun toUserSignCompetitionResult(): UserSignCompetitionResult {
        return UserSignCompetitionResult(id!!.competitionId, id!!.userId, id!!.signTime, status)
    }
}

@Embeddable
data class SignInId(var competitionId: Long, var userId: String, var signTime: LocalDateTime) : Serializable