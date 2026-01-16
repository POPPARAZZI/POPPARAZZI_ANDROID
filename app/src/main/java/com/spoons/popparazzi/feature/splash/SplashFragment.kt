package com.spoons.popparazzi.feature.splash

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.spoons.popparazzi.NavAppDirections
import com.spoons.popparazzi.R
import com.spoons.popparazzi.core.ui.base.fragment.BaseBindFragment
import com.spoons.popparazzi.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment: BaseBindFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    override val containerColor: Int = R.color.color_primary
    private val viewModel: SplashViewModel by viewModels()

    override fun bindUi() {
        super.bindUi()
        viewModel // viewModel 초기화 시점
    }

    override fun regListener() {
        super.regListener()
        binding.root.setOnClickListener {
            findNavController().navigate(NavAppDirections.toOnboarding())
        }
    }
}