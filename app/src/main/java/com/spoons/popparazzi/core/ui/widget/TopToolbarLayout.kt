package com.spoons.popparazzi.core.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.spoons.popparazzi.R
import androidx.core.content.withStyledAttributes

class TopToolbarLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
): ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {
    private lateinit var tvTitle: TextView
    private lateinit var btnBack: ImageView
    private lateinit var btnNoti: ImageView
    private lateinit var btnSetting: ImageView
    private val defaultPadding by lazy { resources.getDimensionPixelSize(R.dimen.spacing_default) }
    private val halfPadding by lazy { resources.getDimensionPixelSize(R.dimen.spacing_half) }

    var onClickToolbar: (TopToolbarType) -> Unit = {}

    var title: String? = null
        set(value) {
            field = value
            tvTitle.text = value
        }

    var isBack: Boolean = false
        set(value) {
            field = value
            btnBack.visibility = if(value) View.VISIBLE else View.GONE
        }

    var isNoti: Boolean = false
        set(value) {
            field = value
            btnNoti.visibility = if(value) View.VISIBLE else View.GONE
            updateBtnPadding()
        }

    var isSetting: Boolean = false
        set(value) {
            field = value
            btnSetting.visibility = if(value) View.VISIBLE else View.GONE
            updateBtnPadding()
        }

    private fun updateBtnPadding() = when {
        isNoti && isSetting -> {
            btnSetting.setPadding(halfPadding, 0, defaultPadding, 0)
            btnNoti.setPadding(defaultPadding, 0 ,halfPadding, 0)
        }
        isNoti -> btnNoti.setPadding(defaultPadding, 0 ,defaultPadding, 0)
        isSetting -> btnSetting.setPadding(defaultPadding, 0, defaultPadding, 0)
        else -> Unit

    }

    private fun initLayout() {
        inflate(context, R.layout.layout_top_toolbar, this)

        tvTitle = findViewById<TextView>(R.id.tv_toolbar_title)
        btnBack = findViewById<ImageView>(R.id.btn_toolbar_back)
        btnNoti = findViewById<ImageView>(R.id.btn_toolbar_noti)
        btnSetting = findViewById<ImageView>(R.id.btn_toolbar_setting)
    }

    private fun regListener() {
        btnBack.setOnClickListener {
            onClickToolbar(TopToolbarType.BACK)
        }
        btnNoti.setOnClickListener {
            onClickToolbar(TopToolbarType.NOTI)
        }
        btnSetting.setOnClickListener {
            onClickToolbar(TopToolbarType.SETTING)
        }
    }

    private fun getAttrs(attrs: AttributeSet?) = context.withStyledAttributes(attrs, R.styleable.TopToolbarLayout) {
        title = getString(R.styleable.TopToolbarLayout_toolbar_title)
        isBack = getBoolean(R.styleable.TopToolbarLayout_toolbar_back, false)
        isNoti = getBoolean(R.styleable.TopToolbarLayout_toolbar_noti, false)
        isSetting = getBoolean(R.styleable.TopToolbarLayout_toolbar_setting, false)
    }

    init {
        initLayout()
        regListener()
        getAttrs(attrs)
    }

    enum class TopToolbarType {
        BACK, NOTI, SETTING
    }
}