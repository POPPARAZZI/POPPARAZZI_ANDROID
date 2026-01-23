package com.spoons.popparazzi.core.data.repository

import com.spoons.popparazzi.core.database.dao.UserDao
import com.spoons.popparazzi.core.database.entity.UserEntity
import com.spoons.popparazzi.core.domain.model.User
import com.spoons.popparazzi.core.network.api.UserApi
import com.spoons.popparazzi.core.network.dto.UserDto
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class UserRepositoryImplTest {
    private class FakeUserApi : UserApi {
        override suspend fun getUser(): UserDto {
            return UserDto(id = "apiTest", name = "apiTest")
        }
    }

    private class FakeUserDao : UserDao {
        override fun select(): UserEntity? = UserEntity("dbTest", "dbTest")
    }

    @Test
    fun `getUser dto to entity to domain`() = runTest {
        val api = FakeUserApi()
        val dao = FakeUserDao()
        val repo = UserRepositoryImpl(api = api, dao = dao)

        val user: User? = repo.getUser()

        assertEquals(User(id = "apiTest", name = "apiTest"), user)
    }
}