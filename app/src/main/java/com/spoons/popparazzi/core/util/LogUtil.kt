package com.spoons.popparazzi.core.util

import android.util.Log

object LogUtil {
    private const val TAG = "POPPARAZZI"
    const val DEBUG = true

    fun d(msg: Any?) {
        if(DEBUG) Log.d(TAG, "$msg")
    }

    fun e(msg: Any?) {
        if(DEBUG) Log.e(TAG, "$msg")
    }

    fun i(msg: Any?) {
        if(DEBUG) Log.i(TAG, "$msg")
    }

    fun w(msg: Any?) {
        if(DEBUG) Log.w(TAG, "$msg")
    }

}