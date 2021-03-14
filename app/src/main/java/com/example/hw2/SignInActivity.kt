package com.example.hw2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        initButton()
        initTextViews()
    }

    private fun initTextViews() {
        val textView = findViewById<TextView>(R.id.textView_no_account)
        textView.setOnClickListener {
            val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initButton() {
        val button = findViewById<Button>(R.id.login_btn)
        button.setOnClickListener {
            onButtonClick()
        }
    }

    private fun onButtonClick() {
        if (isFieldsNoEmpty())
            ShowAlert()
        else
            ShowAlert("Все поля должны быть заполнены")
    }

    private fun isFieldsNoEmpty(): Boolean {
        val email = findViewById<EditText>(R.id.mail)
        val password = findViewById<EditText>(R.id.password)
        return email.text.isNotEmpty() && password.text.isNotEmpty()
    }

    private fun ShowAlert(message: String = "") {
        val alert = findViewById<TextView>(R.id.alert)
        alert.text = message
    }
}