package com.spoons.popparazzi.core.domain.interactor.user

import com.spoons.popparazzi.core.domain.model.User
import com.spoons.popparazzi.core.domain.repository.UserRepository
import com.spoons.popparazzi.core.domain.usecase.user.GetUserUseCase
import javax.inject.Inject

class GetUserUseCaseImpl @Inject constructor(
    private val repository: UserRepository
): GetUserUseCase {
    override suspend fun invoke(): User? = repository.getUser()
}