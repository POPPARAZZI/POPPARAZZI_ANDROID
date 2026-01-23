package com.spoons.popparazzi.core.domain.repository

import com.spoons.popparazzi.core.domain.model.User

interface UserRepository {
    suspend fun getUser(): User?
}