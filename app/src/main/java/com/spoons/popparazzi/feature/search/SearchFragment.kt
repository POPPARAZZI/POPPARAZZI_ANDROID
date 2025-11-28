package com.spoons.popparazzi.feature.search

import com.spoons.popparazzi.core.ui.base.fragment.BaseViewBindingFragment
import com.spoons.popparazzi.databinding.FragmentSearchBinding

class SearchFragment: BaseViewBindingFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {

    override fun regListener() {
        super.regListener()

        binding.clSearch.setOnClickListener {
            binding.motion.transitionToStart()
        }

        binding.clCategory.setOnClickListener {
            binding.motion.transitionToEnd()
        }
    }
}