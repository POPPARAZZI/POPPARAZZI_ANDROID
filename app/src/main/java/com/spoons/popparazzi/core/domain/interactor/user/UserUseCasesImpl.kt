package com.spoons.popparazzi.core.domain.interactor.user

import com.spoons.popparazzi.core.domain.usecase.user.GetUserUseCase
import com.spoons.popparazzi.core.domain.usecase.user.UserUseCases
import javax.inject.Inject

class UserUseCasesImpl @Inject constructor(
    override val getUserUseCase: GetUserUseCase
): UserUseCases