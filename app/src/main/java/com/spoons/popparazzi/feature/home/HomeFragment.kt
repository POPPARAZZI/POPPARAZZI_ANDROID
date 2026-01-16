package com.spoons.popparazzi.feature.home

import androidx.fragment.app.viewModels
import com.spoons.popparazzi.core.ui.base.fragment.BaseViewBindingFragment
import com.spoons.popparazzi.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: BaseViewBindingFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val viewModel: HomeViewModel by viewModels()
}