package com.spoons.popparazzi.core.ui.message

import androidx.annotation.StringRes


sealed class CallbackMessage {
    class ShowToastRes(@param:StringRes val format: Int, val args: Array<Any?> = arrayOf()): CallbackMessage()
    class ShowToastStr(val msg: String): CallbackMessage()
    class ShowConfirmAlertRes(@param:StringRes val format: Int, val args: Array<Any?> = arrayOf(), val callback: (Boolean) -> Unit = {}): CallbackMessage()
    class ShowConfirmAlertStr(val msg: String, val callback: (Boolean) -> Unit = {}): CallbackMessage()
}