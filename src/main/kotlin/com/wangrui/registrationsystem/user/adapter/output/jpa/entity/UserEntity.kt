package com.wangrui.registrationsystem.user.adapter.output.jpa.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table
open class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    /**
     * 微信在某个小程序中的id
     */
    open var openId: String? = null

    /**
     * 微信的全局id，即同一个用户在多个小程序中，他的unionid是相同的
     */
    open var unionId: String? = null

    /**
     * 在报名程序用的用户名
     */
    open var username: String? = null

    /**
     * 在报名程序中的别名，昵称
     */
    open var nickname: String? = null

    /**
     * 最后一次登录的时间，用于判断活跃度
     */
    open var latestLoginDate: LocalDateTime? = null
}