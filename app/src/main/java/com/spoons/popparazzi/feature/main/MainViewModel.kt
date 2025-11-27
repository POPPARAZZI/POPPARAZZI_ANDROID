package com.spoons.popparazzi.feature.main

import com.spoons.popparazzi.core.ui.base.viewmodel.BaseViewmodel
import com.spoons.popparazzi.core.ui.widget.BottomTabLayout

class MainViewModel: BaseViewmodel() {
    var currentTab: BottomTabLayout.TabType = BottomTabLayout.TabType.HOME
}