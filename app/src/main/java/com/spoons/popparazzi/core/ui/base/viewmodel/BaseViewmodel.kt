package com.spoons.popparazzi.core.ui.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spoons.popparazzi.core.util.LogUtil
import kotlinx.coroutines.cancel

abstract class BaseViewmodel: ViewModel(){

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

    protected fun e(msg: Any?) = LogUtil.e("## [${this.javaClass.simpleName}] $msg")
    protected fun d(msg: Any?) = LogUtil.d("## [${this.javaClass.simpleName}] $msg")
    protected fun i(msg: Any?) = LogUtil.i("## [${this.javaClass.simpleName}] $msg")
    protected fun w(msg: Any?) = LogUtil.w("## [${this.javaClass.simpleName}] $msg")
}