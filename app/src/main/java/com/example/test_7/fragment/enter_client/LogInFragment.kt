package com.example.test_7.fragment.enter_client

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.test_7.R
import com.example.test_7.ui.activities.home.HomeActivity
import kotlinx.android.synthetic.main.fragment_enter_client.*
import kotlinx.android.synthetic.main.fragment_forget_password.*
import kotlinx.android.synthetic.main.fragment_log_in.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LogInFragment : Fragment(R.layout.fragment_log_in) {
    private val navController by lazy { findNavController() }

    //Counter is for check field
    var counter = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //onFocus
        et_fragment_log_in_password.setOnFocusChangeListener { v, b ->
            if (!b) {
                if (et_fragment_log_in_password.text.toString().isEmpty())
                    et_fragment_log_in_password.error = "Email is required!"
                else
                    et_fragment_log_in_password.error = null
            }
        }

        //onClick
        tv_fragment_log_in_forget.setOnClickListener {
            navController.navigate(
                LogInFragmentDirections.actionFragmentLogInToFragmentForgetPassword()
            )
        }
        btn_fragment_log_in_continue.setOnClickListener {
            if (counter != 1) {
                counter = 0

                if (et_fragment_log_in_password.text.toString().isEmpty())
                    et_fragment_log_in_password.error = "Please enter your Password!"
                else
                    counter++
            }

            if (counter == 1) {
                var passwordValueEnterClient = et_fragment_log_in_password.text.toString()

                val sharedPref: SharedPreferences =
                    requireActivity().getSharedPreferences("app", Context.MODE_PRIVATE)
                val editor: SharedPreferences.Editor = sharedPref.edit()

                editor.putString("appPassword", passwordValueEnterClient)

                editor.apply()

                if (passwordValueEnterClient == "12345678") {
                    startActivity(Intent(this.requireActivity(), HomeActivity::class.java))
                    requireActivity().finish()
                } else
                    et_fragment_log_in_password.error = "Password is incorrect"
            }
        }
    }

    override fun onResume() {
        super.onResume()
        //animation fields
        et_fragment_log_in_password.translationX = -100f
        btn_fragment_log_in_continue.translationX = 100f

        cv_fragment_log_in_profile.animate().alpha(1f).duration = 1000
        et_fragment_log_in_password.animate().alpha(1f).translationXBy(100f).duration = 1000
        btn_fragment_log_in_continue.animate().alpha(1f).translationXBy(-100f).duration = 1000
        tv_fragment_log_in_forget.animate().alpha(1f).duration = 2000

        //animation text
        tv_fragment_log_in_log_in.typeWrite(this,
            "Log in",
            33L)
        tv_fragment_log_in_log_in.typeWrite(viewLifecycleOwner,
            "Log in",
            33L)

        tv_fragment_log_in_name.typeWrite(this,
            "Jane Dow",
            33L)
        tv_fragment_log_in_name.typeWrite(viewLifecycleOwner,
            "Jane Dow",
            33L)

        tv_fragment_log_in_gmail.typeWrite(this,
            "jane.doe@gmail.com",
            33L)
        tv_fragment_log_in_gmail.typeWrite(viewLifecycleOwner,
            "jane.doe@gmail.com",
            33L)
    }

    private fun TextView.typeWrite(lifecycleOwner: LifecycleOwner, text: String, intervalMs: Long) {
        this@typeWrite.text = ""
        lifecycleOwner.lifecycleScope.launch {
            repeat(text.length) {
                delay(intervalMs)
                this@typeWrite.text = text.take(it + 1)
            }
        }
    }
}