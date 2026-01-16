package com.spoons.popparazzi.feature.onboarding

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.spoons.popparazzi.R
import com.spoons.popparazzi.core.ui.base.viewmodel.BaseViewmodel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(): BaseViewmodel() {
    val pageList: List<OnboardingPage> by lazy { listOf(
        OnboardingPage(R.drawable.onboarding1, R.string.onboarding_title_1, R.string.onboarding_info_1),
        OnboardingPage(R.drawable.onboarding2, R.string.onboarding_title_2, R.string.onboarding_info_2),
        OnboardingPage(R.drawable.onboarding3, R.string.onboarding_title_3, R.string.onboarding_info_3)
    ) }

    data class OnboardingPage(
        @param:DrawableRes val img: Int,
        @param:StringRes val title: Int,
        @param:StringRes val info: Int
    )
}