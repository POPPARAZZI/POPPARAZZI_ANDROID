package com.spoons.popparazzi.feature.splash

import com.spoons.popparazzi.R
import com.spoons.popparazzi.core.ui.base.BaseBindFragment
import com.spoons.popparazzi.databinding.FragmentSplashBinding

class SplashFragment: BaseBindFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    override val containerColor: Int = R.color.color_primary
}