package com.example.test_7.fragment.enter_client

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.example.test_7.R
import kotlinx.android.synthetic.main.fragment_forget_password.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ForgetPasswordFragment : Fragment(R.layout.fragment_forget_password) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        et_fragment_forget_password_email.translationX = -100f
        btn_Fragment_forget_password_continue.translationX = 100f

        et_fragment_forget_password_email.animate().alpha(1f).translationXBy(100f).duration = 1000
        btn_Fragment_forget_password_continue.animate().alpha(1f).translationXBy(-100f).duration = 1000

        tv_fragment_forget_password_forget.typeWrite(this,
            "Forget password?",
            33L)
        tv_fragment_forget_password_forget.typeWrite(viewLifecycleOwner,
            "Forget password?",
            33L)

        tv_Fragment_forget_password_do_not_worry.typeWrite(this,
            "Don't worry! Please enter the address associate with your account.",
            33L)
        tv_Fragment_forget_password_do_not_worry.typeWrite(viewLifecycleOwner,
            "Don't worry! Please enter the address associate with your account.",
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