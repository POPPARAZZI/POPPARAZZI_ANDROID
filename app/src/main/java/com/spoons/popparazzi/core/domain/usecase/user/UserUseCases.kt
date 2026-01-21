package com.spoons.popparazzi.core.domain.usecase.user

import javax.inject.Inject

data class UserUseCases @Inject constructor(
    val getUser: GetUserUseCase
)