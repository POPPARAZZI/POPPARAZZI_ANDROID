package com.spoons.popparazzi.core.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

abstract class BaseBindFragment<VB: ViewBinding>(private val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB): BaseFragment() {
    protected lateinit var binding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = bindingInflater(inflater, container, false)
        bindUi()
        return binding.root
    }
}