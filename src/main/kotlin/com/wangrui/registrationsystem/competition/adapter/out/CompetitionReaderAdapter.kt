package com.wangrui.registrationsystem.competition.adapter.out

import com.wangrui.registrationsystem.competition.application.port.out.CompetitionReaderPort
import com.wangrui.registrationsystem.competition.domain.Competition
import com.wangrui.registrationsystem.competition.domain.CompetitionId
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

/**
 * Created on 2023/3/7 23:13.
 * @author wangrui
 * @since 0.0.1
 */

@Service
class CompetitionReaderAdapter(val repository: CompetitionRepository): CompetitionReaderPort {
    override fun getCompetition(competitionId: CompetitionId): Competition {
        return repository.findById(competitionId).orElseThrow { IllegalArgumentException("无法找到id为 $competitionId 的比赛信息") }
            .toCompetition()
    }
}