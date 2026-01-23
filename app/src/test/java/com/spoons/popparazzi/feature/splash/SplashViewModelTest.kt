package com.spoons.popparazzi.feature.splash

import app.cash.turbine.test
import com.spoons.popparazzi.core.domain.interactor.user.GetUserUseCaseImpl
import com.spoons.popparazzi.core.domain.interactor.user.UserUseCasesImpl
import com.spoons.popparazzi.core.domain.model.User
import com.spoons.popparazzi.core.domain.repository.UserRepository
import com.spoons.popparazzi.core.domain.usecase.user.GetUserUseCase
import com.spoons.popparazzi.core.domain.usecase.user.UserUseCases
import com.spoons.popparazzi.testutil.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class SplashViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private inner class FakeUserRepository(private val user: User?): UserRepository {
        override suspend fun getUser(): User? = user
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `init - when user is null then destination is Login`() = runTest {
        val repo = FakeUserRepository(user = null)
        val getUserUseCase: GetUserUseCase = GetUserUseCaseImpl(repo)
        val userUseCases: UserUseCases = UserUseCasesImpl(getUserUseCase = getUserUseCase)

        val vm = SplashViewModel(userUseCases)

        vm.destination.test {
            advanceUntilIdle()
            assertEquals(SplashViewModel.Destination.Login, awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `init - when user exists then destination is Main`() = runTest {
        val repo = FakeUserRepository(user = User("test", "test"))
        val getUserUseCase: GetUserUseCase = GetUserUseCaseImpl(repo)
        val userUseCases: UserUseCases = UserUseCasesImpl(getUserUseCase = getUserUseCase)

        val vm = SplashViewModel(userUseCases)
        vm.destination.test {
            advanceUntilIdle()
            assertEquals(SplashViewModel.Destination.Main, awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }

}