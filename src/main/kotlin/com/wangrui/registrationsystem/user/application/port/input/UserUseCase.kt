package com.wangrui.registrationsystem.user.application.port.input


import com.wangrui.registrationsystem.user.domain.Participant

interface UserUseCase {

    fun findByUnionId(unionId: String): Participant
}