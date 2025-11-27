package com.spoons.popparazzi.feature.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import com.spoons.popparazzi.core.extention.glide
import com.spoons.popparazzi.core.ui.adapter.adapter.BaseItemAdapter
import com.spoons.popparazzi.core.ui.adapter.viewholder.BaseViewHolder
import com.spoons.popparazzi.databinding.ItemOnboardingBinding


class OnboardingAdapter(items: List<OnboardingViewModel.OnboardingPage>): BaseItemAdapter<OnboardingViewModel.OnboardingPage, OnboardingViewHolder>(items) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val binding = ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OnboardingViewHolder(binding)
    }
}

class OnboardingViewHolder(private val binding: ItemOnboardingBinding): BaseViewHolder<OnboardingViewModel.OnboardingPage>(binding) {
    override fun bind(item: OnboardingViewModel.OnboardingPage) {
        binding.ivOnboarding.glide(item.img)
        binding.tvOnboardingTitle.text = binding.root.context.getString(item.title)
        binding.tvOnboardingInfo.text = binding.root.context.getString(item.info)
    }
}