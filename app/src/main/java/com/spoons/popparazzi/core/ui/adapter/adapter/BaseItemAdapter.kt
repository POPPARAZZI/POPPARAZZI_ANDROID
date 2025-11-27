package com.spoons.popparazzi.core.ui.adapter.adapter

import androidx.recyclerview.widget.RecyclerView
import com.spoons.popparazzi.core.ui.adapter.viewholder.BaseViewHolder

abstract class BaseItemAdapter<T, VH: BaseViewHolder<T>>(val items: List<T>): RecyclerView.Adapter<VH>() {
    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(items[position])
    override fun getItemCount(): Int = items.size
}