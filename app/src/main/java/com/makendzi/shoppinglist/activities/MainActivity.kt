package com.makendzi.shoppinglist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.makendzi.shoppinglist.R
import com.makendzi.shoppinglist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBottomNavListener()
    }

    private fun setBottomNavListener() {
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.settings -> {
                    Log.d("MyTag", "Settings")
                }
                R.id.notes -> {
                    Log.d("MyTag", "Notes")
                }
                R.id.shop_list -> {
                    Log.d("MyTag", "Shoping List")
                }
                R.id.new_item -> {
                    Log.d("MyTag", "New Item")
                }
            }
            true
        }
    }

}