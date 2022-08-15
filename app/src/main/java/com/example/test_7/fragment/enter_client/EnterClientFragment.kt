package com.example.test_7.fragment.enter_client

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.SharedMemory
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.test_7.R
import com.example.test_7.ui.activities.home.HomeActivity
import kotlinx.android.synthetic.main.fragment_enter_client.*
import kotlinx.android.synthetic.main.fragment_log_in.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class EnterClientFragment : Fragment(R.layout.fragment_enter_client), View.OnClickListener {
    private val navController by lazy { findNavController() }

    //Counter is for check field
    var counter = 0
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

        //onFocus
        et_fragment_enter_client_email.setOnFocusChangeListener { v, b ->
            if (!b) {
                if (et_fragment_enter_client_email.text.toString().isEmpty())
                    et_fragment_enter_client_email.error = "Email is required!"
                else
                    et_fragment_enter_client_email.error = null
            }
        }

        //onClick
        tv_fragment_enter_client_sign_up.setOnClickListener(this)
        tv_fragment_enter_client_forget.setOnClickListener(this)
        btn_fragment_enter_client_continue.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        //animation fields
        et_fragment_enter_client_email.translationX = -100f
        btn_fragment_enter_client_continue.translationX = 100f

        et_fragment_enter_client_email.animate().alpha(1f).translationXBy(100f).duration = 1000
        btn_fragment_enter_client_continue.animate().alpha(1f).translationXBy(-100f).duration = 1000
        btn_fragment_enter_client_facebook.animate().alpha(1f).duration = 1500
        btn_fragment_enter_client_google.animate().alpha(1f).duration = 1750
        btn_fragment_enter_client_apple.animate().alpha(1f).duration = 2000
        tv_fragment_enter_client_do_not_account.animate().alpha(1f).duration = 2000
        tv_fragment_enter_client_sign_up.animate().alpha(1f).duration = 2000
        tv_fragment_enter_client_forget.animate().alpha(1f).duration = 2000

        //animation text
        tv_fragment_enter_client_hi.typeWrite(this,
            "Hi!",
            33L)
        tv_fragment_enter_client_hi.typeWrite(viewLifecycleOwner,
            "Hi!",
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

    override fun onClick(view: View?) {
        when (view) {
            tv_fragment_enter_client_sign_up -> {
                navController.navigate(
                    EnterClientFragmentDirections.actionFragmentEnterClientToFragmentSignUp()
                )
            }
            tv_fragment_enter_client_forget -> {
                navController.navigate(
                    EnterClientFragmentDirections.actionFragmentEnterClientToFragmentForgetPassword()
                )
            }
            btn_fragment_enter_client_continue -> {
                if (counter != 1) {
                    counter = 0
                    if (et_fragment_enter_client_email.text.toString().isEmpty())
                        et_fragment_enter_client_email.error = "Please enter your Email!"
                    else
                        counter++
                }

                if (counter == 1) {
                    var emailValueEnterClient = et_fragment_enter_client_email.text.toString()

                    val sharedPref: SharedPreferences =
                        requireActivity().getSharedPreferences("app", Context.MODE_PRIVATE)
                    val editor: SharedPreferences.Editor = sharedPref.edit()

                    editor.putString("appEmail", emailValueEnterClient)

                    editor.apply()

                    if (emailValueEnterClient == "jane.doe@gmail.com")
                        navController.navigate(
                            EnterClientFragmentDirections.actionFragmentEnterClientToFragmentLogIn()
                        )
                    else
                        et_fragment_enter_client_email.error = "Email is incorrect"
                }
            }
        }
    }
}