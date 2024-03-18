package com.wangrui.registrationsystem.competition.adapter.output

import com.wangrui.registrationsystem.competition.adapter.output.jpa.entity.CompetitionEntity
import com.wangrui.registrationsystem.competition.adapter.output.jpa.repository.CompetitionRepository
import com.wangrui.registrationsystem.competition.adapter.output.jpa.repository.SignInId
import com.wangrui.registrationsystem.competition.adapter.output.jpa.repository.SignInInfoEntity
import com.wangrui.registrationsystem.competition.adapter.output.jpa.repository.SignInRepository
import com.wangrui.registrationsystem.competition.application.port.output.CompetitionWritePort
import com.wangrui.registrationsystem.competition.domain.Competition
import com.wangrui.registrationsystem.competition.domain.SignIn
import com.wangrui.registrationsystem.competition.domain.SignInResult
import org.springframework.stereotype.Service
import java.time.LocalDateTime

/**
 * Created on 2023/3/7 23:31.
 * @author wangrui
 * @since 0.0.1
 */
@Service
class CompetitionWriteAdapter(
    val competitionRepository: CompetitionRepository,
    val signInRepository: SignInRepository
) : CompetitionWritePort {
    override fun saveCompetition(competition: Competition): Competition {
        return competitionRepository.save(CompetitionEntity.toCompetitionEntity(competition)).toCompetition()
    }

    override fun signIn(signIn: SignIn): SignInResult {
        val signInInfoEntity = SignInInfoEntity(SignInId(signIn.id, signIn.userId, LocalDateTime.now()), signIn.action)
        signInRepository.save(signInInfoEntity)
        return SignInResult(0)
    }
}