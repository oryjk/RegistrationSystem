package com.wangrui.registrationsystem.user.adapter.output.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table
data class UserEntity(
    @Id val id: String,
    val username: String
)
