package com.spoons.popparazzi.feature.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.spoons.popparazzi.core.ui.base.fragment.BaseViewBindingFragment
import com.spoons.popparazzi.core.ui.widget.BottomTabLayout
import com.spoons.popparazzi.databinding.FragmentMainBinding
import com.spoons.popparazzi.feature.main.chat.ChatFragment
import com.spoons.popparazzi.feature.main.home.HomeFragment
import com.spoons.popparazzi.feature.main.meet.MeetFragment
import com.spoons.popparazzi.feature.main.mypage.MyPageFragment
import com.spoons.popparazzi.feature.main.search.SearchFragment

class MainFragment: BaseViewBindingFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    private val viewModel: MainViewModel by viewModels()
    private val fragmentMap = mutableMapOf<BottomTabLayout.TabType, Fragment>()
    private var activeFragment: Fragment? = null

    override fun bindUi() {
        super.bindUi()
        viewModel // viewModel 초기화 시점

        initMainScreen()
    }

    private fun initMainScreen() {
        initFragments()
        setTab(viewModel.currentTab)
        setFragment(viewModel.currentTab)
    }

    private fun initFragments() {
        fragmentMap[BottomTabLayout.TabType.HOME] = childFragmentManager.findFragmentByTag(BottomTabLayout.TabType.HOME.tag)?: HomeFragment()
        fragmentMap[BottomTabLayout.TabType.SEARCH] = childFragmentManager.findFragmentByTag(BottomTabLayout.TabType.SEARCH.tag)?: SearchFragment()
        fragmentMap[BottomTabLayout.TabType.MEET] = childFragmentManager.findFragmentByTag(BottomTabLayout.TabType.MEET.tag)?: MeetFragment()
        fragmentMap[BottomTabLayout.TabType.CHAT] = childFragmentManager.findFragmentByTag(BottomTabLayout.TabType.CHAT.tag)?: ChatFragment()
        fragmentMap[BottomTabLayout.TabType.MY_PAGE] = childFragmentManager.findFragmentByTag(BottomTabLayout.TabType.MY_PAGE.tag)?: MyPageFragment()
    }

    private fun setFragment(type: BottomTabLayout.TabType) {
        viewModel.currentTab = type
        val change = fragmentMap[type]?: return
        if(change == activeFragment) {
            return
        }
        activeFragment?.let { active ->
            if(change.isAdded) {
                childFragmentManager.beginTransaction().hide(active).show(change).commitAllowingStateLoss()
            } else {
                childFragmentManager.beginTransaction().hide(active).add(binding.main.id, change, type.tag).commitAllowingStateLoss()
            }
        }?: run {
            if(change.isAdded) {
                childFragmentManager.beginTransaction().show(change).commitAllowingStateLoss()
            } else {
                childFragmentManager.beginTransaction().add(binding.main.id, change, type.tag).commitAllowingStateLoss()
            }
        }
        activeFragment = change
    }

    private fun setTab(type: BottomTabLayout.TabType) {
        // todo
    }

    override fun regListener() {
        super.regListener()
        binding.tabBottom.addBottomTabListener(object: BottomTabLayout.BottomTabListener {
            override fun click(type: BottomTabLayout.TabType) = setFragment(type)
        })
    }
}