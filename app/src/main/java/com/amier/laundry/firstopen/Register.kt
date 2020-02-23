package com.amier.laundry.firstopen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amier.laundry.R
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        regist_btn_login.setOnClickListener {
            startActivity(Intent(this,Login::class.java))
            overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right)
        }
    }

}
