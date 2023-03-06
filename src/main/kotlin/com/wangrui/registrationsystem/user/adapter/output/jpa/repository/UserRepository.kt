package com.wangrui.registrationsystem.user.adapter.output.jpa.repository

import com.wangrui.registrationsystem.user.adapter.output.jpa.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {

}