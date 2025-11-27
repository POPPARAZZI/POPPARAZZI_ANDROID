package com.spoons.popparazzi.core.ui.base.fragment

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.spoons.popparazzi.R
import com.spoons.popparazzi.core.ui.message.CallbackMessage
import com.spoons.popparazzi.core.util.LogUtil

abstract class BaseFragment: Fragment() {
    protected open fun bindUi() = Unit
    protected open fun regListener() = Unit
    protected open fun regObserve() = Unit

    open val containerColor: Int = R.color.color_container

    override fun onResume() {
        super.onResume()
        requireActivity().window.decorView.setOnApplyWindowInsetsListener { v, i ->
            v.setBackgroundColor(ContextCompat.getColor(requireContext(), containerColor))
            i
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        regListener()

        regObserve()
    }

    protected fun onCallback(msg: CallbackMessage) = when(msg) {
        is CallbackMessage.ShowToastRes -> Unit
        is CallbackMessage.ShowToastStr -> Unit
        is CallbackMessage.ShowConfirmAlertRes -> Unit
        is CallbackMessage.ShowConfirmAlertStr -> Unit
    }

    protected fun e(msg: Any?) = LogUtil.e("## [${this.javaClass.simpleName}] $msg")
    protected fun d(msg: Any?) = LogUtil.d("## [${this.javaClass.simpleName}] $msg")
    protected fun i(msg: Any?) = LogUtil.i("## [${this.javaClass.simpleName}] $msg")
    protected fun w(msg: Any?) = LogUtil.w("## [${this.javaClass.simpleName}] $msg")
}