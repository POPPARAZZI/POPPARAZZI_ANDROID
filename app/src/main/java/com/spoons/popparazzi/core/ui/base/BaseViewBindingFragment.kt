package com.spoons.popparazzi.core.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.spoons.popparazzi.core.util.ErrorUtil

abstract class BaseViewBindingFragment<VB: ViewBinding>(private val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB): BaseFragment() {
    private var _binding: VB? = null
    protected val binding: VB get() = _binding?: throw ErrorUtil.bindingException()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        if(_binding == null) {
            _binding = bindingInflater(inflater, container, false)
            bindUi()
        }
        return _binding?.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}