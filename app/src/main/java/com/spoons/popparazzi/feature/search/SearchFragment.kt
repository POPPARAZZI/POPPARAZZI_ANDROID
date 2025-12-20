package com.spoons.popparazzi.feature.search

import com.spoons.popparazzi.core.ui.base.fragment.BaseViewBindingFragment
import com.spoons.popparazzi.databinding.FragmentSearchBinding

class SearchFragment: BaseViewBindingFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {

    override fun regListener() {
        super.regListener()

        binding.clSearch.setOnClickListener {
            if(binding.motion.currentState == R.id.motion_hide) binding.motion.setTransition(R.id.t_detail_hide)
            binding.motion.transitionToState(R.id.motion_detail)
        }

        binding.clCategory.setOnClickListener {
            binding.motion.transitionToEnd()
        }
    }
}