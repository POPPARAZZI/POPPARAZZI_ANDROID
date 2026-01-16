package com.spoons.popparazzi.core.network.interceptor

import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import okhttp3.logging.HttpLoggingInterceptor

class ApiLogger : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        val logName = "ApiLogger"
        if (message.startsWith("{") || message.startsWith("[")) {
            try {
                val sb = StringBuilder()
                sb.append("\n######################################################################\n")
                val prettyPrintJson = GsonBuilder().setPrettyPrinting()
                    .create().toJson(JsonParser().parse(message))
                sb.append(prettyPrintJson)
                sb.append("\n######################################################################")
                Log.d(logName, sb.toString())
            } catch (m: JsonSyntaxException) {
                Log.d(logName, message)
            }
        } else {
            Log.d(logName, message)
            return
        }
    }
}