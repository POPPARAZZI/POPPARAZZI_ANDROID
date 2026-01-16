package com.spoons.popparazzi.feature.main

import com.spoons.popparazzi.core.ui.base.viewmodel.BaseViewmodel
import com.spoons.popparazzi.core.ui.widget.BottomTabLayout
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): BaseViewmodel() {
    var currentTab: BottomTabLayout.TabType = BottomTabLayout.TabType.HOME
}