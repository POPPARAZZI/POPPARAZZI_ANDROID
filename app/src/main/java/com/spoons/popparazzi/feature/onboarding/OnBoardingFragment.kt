package com.spoons.popparazzi.feature.onboarding

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.spoons.popparazzi.NavAppDirections
import com.spoons.popparazzi.core.ui.base.fragment.BaseBindFragment
import com.spoons.popparazzi.databinding.FragmentOnboardingBinding

class OnboardingFragment: BaseBindFragment<FragmentOnboardingBinding>(FragmentOnboardingBinding::inflate) {
    private val viewModel: OnboardingViewModel by viewModels()
    private val adapter: OnboardingAdapter by lazy { OnboardingAdapter(viewModel.pageList) }

    override fun bindUi() {
        super.bindUi()
        viewModel // viewModel 초기화 시점
        binding.vpOnboarding.adapter = adapter
        binding.dotOnboarding.attachTo(binding.vpOnboarding)
    }

    override fun regListener() {
        super.regListener()
        binding.btnStart.setOnClickListener {
            findNavController().navigate(NavAppDirections.toLogin())
        }
    }
}