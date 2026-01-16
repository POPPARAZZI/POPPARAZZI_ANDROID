package com.spoons.popparazzi.core.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.spoons.popparazzi.R

class BottomTabLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
): ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {
    private val llList = mutableListOf<LinearLayout>()
    private val ivList = mutableListOf<ImageView>()
    private val tvList = mutableListOf<TextView>()

    var onClickBottomTab: (TabType) -> Unit = {}

    private fun initLayout() {
        inflate(context, R.layout.layout_bottom_tab, this)

        llList.add(findViewById(R.id.ll_home))
        ivList.add(findViewById(R.id.iv_home))
        tvList.add(findViewById(R.id.tv_home))

        llList.add(findViewById(R.id.ll_search))
        ivList.add(findViewById(R.id.iv_search))
        tvList.add(findViewById(R.id.tv_search))

        llList.add(findViewById(R.id.ll_meet))
        ivList.add(findViewById(R.id.iv_meet))
        tvList.add(findViewById(R.id.tv_meet))

        llList.add(findViewById(R.id.ll_chat))
        ivList.add(findViewById(R.id.iv_chat))
        tvList.add(findViewById(R.id.tv_chat))

        llList.add(findViewById(R.id.ll_my))
        ivList.add(findViewById(R.id.iv_my))
        tvList.add(findViewById(R.id.tv_my))
    }

    private fun regListener() {
        llList.forEach { ll ->
            ll.setOnClickListener { onClickTab(ll) }
        }
    }

    private fun onClickTab(v: View) {
        onClickBottomTab(toType(v.id))
        llList.forEachIndexed { idx,  ll ->
            ivList[idx].isSelected = ll == v
            tvList[idx].isSelected = ll == v
        }
    }

    private fun toType(id: Int?): TabType = when(id) {
        R.id.ll_search -> TabType.SEARCH
        R.id.ll_meet -> TabType.MEET
        R.id.ll_chat -> TabType.CHAT
        R.id.ll_my -> TabType.MY_PAGE
        else -> TabType.HOME
    }

    fun setTab(type: TabType) {
        llList.forEachIndexed { idx, _ ->
            ivList[idx].isSelected = idx == type.idx
            tvList[idx].isSelected = idx == type.idx
        }
    }

    init {
        initLayout()
        regListener()
    }

    enum class TabType(val tag: String, val idx: Int) {
        HOME("home", 0), SEARCH("search", 1), MEET("meet", 2), CHAT("chat", 3), MY_PAGE("my_page", 4)
    }
}