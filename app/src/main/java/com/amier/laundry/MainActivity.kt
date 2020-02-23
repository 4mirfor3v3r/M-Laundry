package com.amier.laundry

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.amier.laundry.adapter.VPAdapter
import com.amier.laundry.firstopen.Login
import com.amier.laundry.firstopen.Register
import com.amier.laundry.fragments.AccountFragment
import com.amier.laundry.fragments.HistoryFragment
import com.amier.laundry.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var isLoggedIn: Boolean = false
    lateinit var adapter: VPAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        isLoggedIn = intent.getBooleanExtra("isLoggedIn",false)
//        checkStatus()

        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("")

        adapter = VPAdapter(supportFragmentManager)

        adapter.addFragment(HomeFragment(),"Home")
        adapter.addFragment(HistoryFragment(),"History")
        adapter.addFragment(AccountFragment(),"Account")

        home_vp.adapter = adapter
        home_tablayout.setupWithViewPager(home_vp)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
    private fun checkStatus(){
        if(!isLoggedIn) {
            val intent = Intent(this, Register::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }else
            return
    }
}
