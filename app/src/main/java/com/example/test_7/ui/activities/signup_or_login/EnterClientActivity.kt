package com.example.test_7.ui.activities.signup_or_login

import android.os.Bundle
import android.os.PersistableBundle

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.test_7.R

class EnterClientActivity: AppCompatActivity(R.layout.activity_enter_client) {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val navHostFragmentEnterClient =
            supportFragmentManager.findFragmentById(R.id.navigation_host_enter_client) as NavHostFragment
        /*val navController = navHostFragmentEnterClient.navController*/


    }
}