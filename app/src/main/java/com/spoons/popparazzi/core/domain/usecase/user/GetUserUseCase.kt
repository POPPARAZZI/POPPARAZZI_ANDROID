package com.spoons.popparazzi.core.domain.usecase.user

import com.spoons.popparazzi.core.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke() = repository.getUser()
}