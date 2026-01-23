package com.spoons.popparazzi.core.domain.usecase.user

import com.spoons.popparazzi.core.domain.model.User
import com.spoons.popparazzi.core.domain.repository.UserRepository
import javax.inject.Inject

interface GetUserUseCase {
    suspend operator fun invoke(): User?
}

//class GetUserUseCase @Inject constructor(
//    private val repository: UserRepository
//) {
//    suspend operator fun invoke() = repository.getUser()
//}