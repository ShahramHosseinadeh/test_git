package com.example.test_7.fragment.first_fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import coil.load
import com.example.test_7.MainActivity
import com.example.test_7.R
import com.example.test_7.ui.activities.home.HomeActivity
import com.example.test_7.ui.activities.signup_or_login.EnterClientActivity
import kotlinx.android.synthetic.main.fragment_fifth.*

class FifthFragment : Fragment(R.layout.fragment_fifth) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_fragment_fifth_get_started.setOnClickListener{

            startActivity(Intent(this.activity, EnterClientActivity::class.java))
            /*ActivityCompat.finishAffinity(MainActivity());*/
            this.activity?.finish()
        }
    }
}