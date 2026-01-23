package com.spoons.popparazzi.feature.splash

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.spoons.popparazzi.NavAppDirections
import com.spoons.popparazzi.R
import com.spoons.popparazzi.core.ui.base.fragment.BaseBindFragment
import com.spoons.popparazzi.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment: BaseBindFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    override val containerColor: Int = R.color.red500_primary
    private val viewModel: SplashViewModel by viewModels()

    override fun bindUi() {
        super.bindUi()
        viewModel // viewModel 초기화 시점
    }

    override fun regObserve() {
        super.regObserve()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.destination.collect { destination ->
                val direction = when(destination) {
                    is SplashViewModel.Destination.Login -> NavAppDirections.toLogin()
                    is SplashViewModel.Destination.Main -> NavAppDirections.toMainContainer()
                }
                findNavController().navigate(direction)
            }
        }
    }

}