package com.amier.laundry.adapter

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class VPAdapter(supportFragmentManager: FragmentManager):FragmentStatePagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()
    private var lastPosition = 0

    override fun getItem(position: Int): Fragment {
        lastPosition = position
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }

    fun addFragment(fragment: Fragment, title:String){
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    fun getLastPosition():Int{

        Log.e("LAST POSITION",lastPosition.toString())

        return when (lastPosition) {
            mFragmentList.lastIndex -> lastPosition
            0 -> lastPosition
            else -> -1
        }
    }
}