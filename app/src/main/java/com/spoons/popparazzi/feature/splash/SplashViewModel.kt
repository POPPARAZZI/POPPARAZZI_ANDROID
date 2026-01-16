package com.spoons.popparazzi.feature.splash

import com.spoons.popparazzi.core.domain.usecase.user.GetUserUseCase
import com.spoons.popparazzi.core.ui.base.viewmodel.BaseViewmodel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val getUserUseCase: GetUserUseCase): BaseViewmodel() {
}