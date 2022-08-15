package com.example.test_7

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.test_7.ui.adapter.ShopViewPagerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_bottom_navigation.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        val viewPager : ViewPager2 = view_pager
        viewPager.adapter = ShopViewPagerAdapter(this@MainActivity)
        dotsIndicator.attachTo(viewPager)

        /*btm_navigation.setOnNavigationItemReselectedListener { item ->
            when (item.itemId) {
                R.id.fragment_home -> {
                    item.setIcon(R.drawable.ic_cart)
                }
                R.id.fragment_menu -> {
                    // Respond to navigation item 2 reselection
                }
                R.id.fragment_cart -> {
                    // Respond to navigation item 2 reselection
                }
                R.id.fragment_profile -> {
                    // Respond to navigation item 2 reselection
                }
            }
        }*/
    }

}