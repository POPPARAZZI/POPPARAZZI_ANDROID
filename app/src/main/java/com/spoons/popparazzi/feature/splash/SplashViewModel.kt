package com.spoons.popparazzi.feature.splash

import androidx.lifecycle.viewModelScope
import com.spoons.popparazzi.core.domain.usecase.user.UserUseCases
import com.spoons.popparazzi.core.ui.base.viewmodel.BaseViewmodel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val userUseCases: UserUseCases
): BaseViewmodel() {
    private val _destination = MutableSharedFlow<Destination>()
    val destination: SharedFlow<Destination> = _destination.asSharedFlow()

    sealed class Destination {
        data object Login: Destination()
        data object Main: Destination()
    }

    private fun loadUser() = viewModelScope.launch(Dispatchers.Main) {
        val user = withContext(Dispatchers.IO) { userUseCases.getUserUseCase() }
        _destination.emit(if(user == null) Destination.Login else Destination.Main)
    }

    init {
        loadUser()
    }
}