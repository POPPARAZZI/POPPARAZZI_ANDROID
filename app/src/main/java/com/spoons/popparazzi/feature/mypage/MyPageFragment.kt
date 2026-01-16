package com.spoons.popparazzi.feature.mypage

import com.spoons.popparazzi.core.ui.base.fragment.BaseViewBindingFragment
import com.spoons.popparazzi.databinding.FragmentMyPageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageFragment: BaseViewBindingFragment<FragmentMyPageBinding>(FragmentMyPageBinding::inflate) {
}