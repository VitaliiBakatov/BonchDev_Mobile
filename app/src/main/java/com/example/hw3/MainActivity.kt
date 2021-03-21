package com.example.hw3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val signUpFragment = SignUpFragment()
    private val signInFragment = SignInFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.container, signInFragment).commit()
    }

    fun goToSignUpFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.container, signUpFragment).addToBackStack(null)
            .commit()
    }
    fun goToSignInFragment(){
        supportFragmentManager.popBackStack()
    }
}