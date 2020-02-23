package com.amier.laundry.util

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.amier.laundry.R


class FirstopenProgressbar(view: View) {
    lateinit var layout:LinearLayout
    lateinit var progressbar: ProgressBar
    lateinit var textView:TextView
    init {
        layout = view.findViewById(R.id.first_layout)
        progressbar = view.findViewById(R.id.first_progressbar)
        textView = view.findViewById(R.id.first_tv)
    }
    fun btnActivated(){
        progressbar.visibility = View.VISIBLE
        textView.text = "Please wait..."
    }
    fun buttonFinished(){
        layout.setBackgroundResource(R.drawable.firstopen_end)
        progressbar.visibility = View.GONE
        textView.text = "Done"
    }
}