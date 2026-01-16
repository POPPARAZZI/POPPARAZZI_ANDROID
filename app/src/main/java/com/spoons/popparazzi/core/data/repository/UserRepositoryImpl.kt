package com.spoons.popparazzi.core.data.repository

import com.spoons.popparazzi.core.data.mapper.toDomain
import com.spoons.popparazzi.core.data.mapper.toEntity
import com.spoons.popparazzi.core.database.dao.UserDao
import com.spoons.popparazzi.core.domain.model.User
import com.spoons.popparazzi.core.domain.repository.UserRepository
import com.spoons.popparazzi.core.network.api.UserApi
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi,
    private val dao: UserDao
): UserRepository {
    override suspend fun getUser(): User = api.getUser().toEntity().toDomain()
}