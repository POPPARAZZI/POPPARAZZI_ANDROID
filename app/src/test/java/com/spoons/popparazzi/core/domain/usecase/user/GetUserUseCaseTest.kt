package com.spoons.popparazzi.core.domain.usecase.user

import com.spoons.popparazzi.core.domain.interactor.user.GetUserUseCaseImpl
import com.spoons.popparazzi.core.domain.model.User
import com.spoons.popparazzi.core.domain.repository.UserRepository
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.*

class GetUserUseCaseTest {

    private inner class FakeUserRepository: UserRepository {
        override suspend fun getUser(): User? = User("testId", "testName")
    }

    @Test
    fun `getUser return user`() = runTest {
        val useCase: GetUserUseCase = GetUserUseCaseImpl(FakeUserRepository())
        val user = useCase()
        assertEquals(User("testId", "testName") ,user)
    }
}