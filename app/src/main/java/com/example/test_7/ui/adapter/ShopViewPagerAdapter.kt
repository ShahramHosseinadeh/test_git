package com.example.test_7.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.test_7.MainActivity
import com.example.test_7.fragment.first_fragments.*

class ShopViewPagerAdapter(ac: MainActivity) : FragmentStateAdapter(ac) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            2 -> ThirdFragment()
            3 -> FourthFragment()
            4 -> FifthFragment()
            else -> FirstFragment()
        }
    }
}