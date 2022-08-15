package com.example.test_7.fragment.first_fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.test_7.R
import com.example.test_7.ui.activities.home.HomeActivity

class FirstFragment : Fragment(R.layout.fragment_first) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var sharedPref: SharedPreferences =
            requireActivity().getSharedPreferences("app", Context.MODE_PRIVATE)

        var email = sharedPref.getString("appEmail", "")
        var password = sharedPref.getString("appPassword", "")

        if (email!!.isNotEmpty() && password!!.isNotEmpty()) {
            startActivity(Intent(this.requireActivity(), HomeActivity::class.java))
            requireActivity().finish()
        }
    }
}