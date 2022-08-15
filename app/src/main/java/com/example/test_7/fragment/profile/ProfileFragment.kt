package com.example.test_7.fragment.profile

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.test_7.R
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    lateinit var sharedPref: SharedPreferences
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireActivity().getSharedPreferences("app", Context.MODE_PRIVATE)
        val name = sharedPref.getString("appName", "")
        if (!name.isNullOrEmpty())
            tv_fragment_profile_name.text = name
    }
}