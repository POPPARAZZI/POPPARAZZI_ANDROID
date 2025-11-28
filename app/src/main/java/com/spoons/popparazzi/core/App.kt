package com.spoons.popparazzi.core

import android.app.Application
import com.naver.maps.map.NaverMapSdk
import com.spoons.popparazzi.BuildConfig

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        initNaverMap()
    }

    private fun initNaverMap() {
        NaverMapSdk.getInstance(this).client = NaverMapSdk.NcpKeyClient(BuildConfig.NAVER_CLIENT_ID)
    }
}