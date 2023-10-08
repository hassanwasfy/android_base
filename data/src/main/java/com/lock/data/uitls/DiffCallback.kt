package com.dezz.data.uitls

import androidx.recyclerview.widget.DiffUtil


class DiffCallback<T>(private val newItems: ArrayList<T?>?, private var oldItems: ArrayList<T?>?) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldItems?.size ?: 0
    }

    override fun getNewListSize(): Int {
        return newItems?.size ?: 0
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems?.get(oldItemPosition)?.equals(newItems?.get(newItemPosition)) == true
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems?.get(oldItemPosition)?.equals(newItems?.get(newItemPosition)) == true
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }

}