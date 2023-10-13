package com.wangrui.registrationsystem.common

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Created on 2023/10/13 17:30.
 * @author wangrui
 * @since 0.0.1
 */

inline fun <reified T> T.slf4j(): Logger = LoggerFactory.getLogger(T::class.java)