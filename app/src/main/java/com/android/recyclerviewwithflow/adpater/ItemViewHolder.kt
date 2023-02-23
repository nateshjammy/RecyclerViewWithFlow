package com.android.recyclerviewwithflow.adpater

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.recyclerviewwithflow.R
import com.android.recyclerviewwithflow.pojo.MyItem

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textView: TextView = itemView.findViewById(R.id.item_text_view)

    fun bind(item: MyItem) {
        textView.text = item.title
    }
}