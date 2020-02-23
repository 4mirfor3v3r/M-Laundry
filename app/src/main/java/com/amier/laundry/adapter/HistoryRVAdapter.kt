package com.amier.laundry.adapter

import com.amier.laundry.R
import com.amier.laundry.model.History
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.item_history_rv.view.*

class HistoryRVAdapter(val history: History):Item<GroupieViewHolder>() {
    override fun getLayout(): Int {
        return R.layout.item_history_rv
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.item_history_orderid.text = history.id
        viewHolder.itemView.item_history_place.text = history.tempat
        viewHolder.itemView.item_history_time.text = history.waktu
    }
}