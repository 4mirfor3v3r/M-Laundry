package com.amier.laundry.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.amier.laundry.R
import com.amier.laundry.adapter.HistoryRVAdapter
import com.amier.laundry.util.Dummy
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_history.view.*

class HistoryFragment : Fragment() {

    val adapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val x = inflater.inflate(R.layout.fragment_history, container, false)
//        x.history_rv.layoutAnimation
        Dummy.historyDummy.forEach {
            adapter.add(HistoryRVAdapter(it))
            adapter.notifyDataSetChanged()
        }

        x.history_rv.adapter = adapter
        return x
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }


}
