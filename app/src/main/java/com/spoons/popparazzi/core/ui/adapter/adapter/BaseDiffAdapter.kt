package com.spoons.popparazzi.core.ui.adapter.adapter

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.spoons.popparazzi.core.ui.adapter.viewholder.BaseViewHolder

abstract class BaseDiffAdapter<T, VH: BaseViewHolder<T>>: RecyclerView.Adapter<VH>() {
    protected abstract val asyncDiffer: AsyncListDiffer<T>
    fun submitList(list: List<T>, callback: () -> Unit = {}) = asyncDiffer.submitList(list, callback)

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(asyncDiffer.currentList[position])
    override fun getItemCount(): Int = asyncDiffer.currentList.size
}