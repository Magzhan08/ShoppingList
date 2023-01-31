package com.makendzi.shoppinglist.fragments

import androidx.appcompat.app.AppCompatActivity
import com.makendzi.shoppinglist.R

object FragmentManager {
    var currentFragment: BaseFragment? = null

    fun setFragment(newFragment: BaseFragment, activity: AppCompatActivity) {
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.place_holder, newFragment)
        transaction.commit()
        currentFragment = newFragment
    }
}