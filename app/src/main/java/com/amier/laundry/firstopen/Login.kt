package com.amier.laundry.firstopen

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.amier.laundry.MainActivity
import com.amier.laundry.R
import kotlinx.android.synthetic.main.activity_login.*


class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_btn_register.setOnClickListener {
            onBackPressed()
        }
        login_btn_login.setOnClickListener {

            performLogin()
        }
    }
    fun performLogin(){
        val view = login_btn_login
        val layout = view as LinearLayout
        val progressbar = view.findViewById<ProgressBar>(R.id.first_progressbar)
        val textView = view.findViewById<TextView>(R.id.first_tv)

        progressbar.visibility = View.VISIBLE
        textView.text = "Please wait..."

        Handler().postDelayed({
            layout.background.colorFilter = PorterDuffColorFilter(
                Color.parseColor("#2CC200"),
                PorterDuff.Mode.SRC_ATOP
            )
            progressbar.visibility = View.GONE
            textView.text = "Done"
            Handler().postDelayed({
                startActivity(Intent(this,MainActivity::class.java).putExtra("isLoggedIn",true))
            },800)
        },3000)
    }

//    fun cardflip(view:View){
//            val oa1 = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f)
//            val oa2 = ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f)
//            oa1.interpolator = DecelerateInterpolator()
//            oa2.interpolator = AccelerateDecelerateInterpolator()
//            oa1.addListener(object : AnimatorListenerAdapter() {
//                override fun onAnimationEnd(animation: Animator) {
//                    super.onAnimationEnd(animation)
//                    oa2.start()
//                }
//            })
//            oa1.start()
//    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left)
    }
}
