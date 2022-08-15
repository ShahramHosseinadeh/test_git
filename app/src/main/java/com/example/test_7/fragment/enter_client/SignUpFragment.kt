package com.example.test_7.fragment.enter_client

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.example.test_7.R
import com.example.test_7.ui.activities.home.HomeActivity
import kotlinx.android.synthetic.main.fragment_enter_client.*
import kotlinx.android.synthetic.main.fragment_forget_password.*
import kotlinx.android.synthetic.main.fragment_shop_detail_product.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SignUpFragment : Fragment(R.layout.fragment_sign_up), View.OnClickListener,
    View.OnFocusChangeListener {
    //count is for check field
    var counter = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var sharedPref: SharedPreferences =
            requireActivity().getSharedPreferences("app", Context.MODE_PRIVATE)
        var name = sharedPref.getString("appName", "")
        var email = sharedPref.getString("appEmail", "")
        var password = sharedPref.getString("appPassword", "")

        if (name!!.isNotEmpty() && email!!.isNotEmpty() && password!!.isNotEmpty()) {
            startActivity(Intent(this.requireActivity(), HomeActivity::class.java))
            requireActivity().finish()
        }

        //onFocus
        et_fragment_sign_up_name.onFocusChangeListener = this
        et_fragment_sign_up_email.onFocusChangeListener = this
        et_fragment_sign_up_password.onFocusChangeListener = this

        //onClick
        btn_fragment_sign_up_continue.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        //animation field
        et_fragment_sign_up_name.translationX = -100f
        et_fragment_sign_up_email.translationX = 100f
        et_fragment_sign_up_password.translationX = -100f

        tv_fragment_sign_up_maximo.animate().alpha(1f).duration = 1000
        et_fragment_sign_up_name.animate().alpha(1f).translationXBy(100f).duration = 1000
        et_fragment_sign_up_email.animate().alpha(1f).translationXBy(-100f).duration = 1000
        et_fragment_sign_up_password.animate().alpha(1f).translationXBy(100f).duration = 1000
        cb_fragment_sign_up_terms.animate().alpha(1f).duration = 2000
        tv_fragment_sign_up_agree.animate().alpha(1f).duration = 2000
        btn_fragment_sign_up_continue.animate().alpha(1f).duration = 2000

        //animation text
        tv_fragment_sign_up_sign_up.typeWrite(this,
            "Sign up",
            33L)
        tv_fragment_sign_up_sign_up.typeWrite(viewLifecycleOwner,
            "Sign up",
            33L)

        tv_fragment_sign_up_looks_like.typeWrite(this,
            "Looks like you don't have an account. Let's create a new account for you in",
            33L)
        tv_fragment_sign_up_looks_like.typeWrite(viewLifecycleOwner,
            "Looks like you don't have an account. Let's create a new account for you in",
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

    @SuppressLint("CommitPrefEdits")
    override fun onClick(view: View?) {
        when (view) {
            btn_fragment_sign_up_continue -> {
                if (counter != 3) {
                    counter = 0

                    if (et_fragment_sign_up_name.text.toString().isEmpty())
                        et_fragment_sign_up_name.error = "Name is required!"
                    else
                        counter++

                    if (et_fragment_sign_up_email.text.toString().isEmpty())
                        et_fragment_sign_up_email.error = "Email is required!"
                    else
                        counter++

                    if (et_fragment_sign_up_password.text.toString().isEmpty())
                        et_fragment_sign_up_password.error = "Password is required!"
                    else
                        counter++
                }

                if (counter == 3) {
                    //to get user name and save
                    val nameValue = et_fragment_sign_up_name.text.toString()
                    val emailValue = et_fragment_sign_up_email.text.toString()
                    val passwordValue = et_fragment_sign_up_password.text.toString()

                    val sharedPref: SharedPreferences =
                        requireActivity().getSharedPreferences("app", Context.MODE_PRIVATE)
                    val editor: SharedPreferences.Editor = sharedPref.edit()

                    editor.putString("appName", nameValue)
                    editor.putString("appEmail", emailValue)
                    editor.putString("appPassword", passwordValue)

                    editor.apply()

                    if (cb_fragment_sign_up_terms.isChecked) {
                        startActivity(Intent(this.requireActivity(), HomeActivity::class.java))
                        requireActivity().finish()
                    } else
                        Toast.makeText(this.requireActivity(),
                            "Please agree to Terms & Privacy",
                            Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onFocusChange(view: View?, b: Boolean) {
        when (view) {
            et_fragment_sign_up_name -> {
                if (!b) {
                    if (et_fragment_sign_up_name.text.toString().isEmpty())
                        et_fragment_sign_up_name.error = "Name is required!"
                    else
                        et_fragment_sign_up_name.error = null
                }
            }
            et_fragment_sign_up_email -> {
                if (!b) {
                    if (et_fragment_sign_up_email.text.toString().isEmpty())
                        et_fragment_sign_up_email.error = "Email is required!"
                    else
                        et_fragment_sign_up_email.error = null
                }
            }
            et_fragment_sign_up_password -> {
                if (!b) {
                    if (et_fragment_sign_up_password.text.toString().isEmpty())
                        et_fragment_sign_up_password.error = "Password is required!"
                    else
                        et_fragment_sign_up_password.error = null
                }
            }
        }
    }
}