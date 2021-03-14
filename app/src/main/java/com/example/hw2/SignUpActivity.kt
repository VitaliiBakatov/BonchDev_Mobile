package com.example.hw2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        initButton()
        initTextViews()
    }

    private fun initTextViews() {
        val textView = findViewById<TextView>(R.id.textView_account)
        textView.setOnClickListener {
            super.onBackPressed()
        }
    }

    private fun initButton() {
        val button = findViewById<Button>(R.id.reg_btn)
        button.setOnClickListener {
            onButtonClick()
        }
    }

    private fun onButtonClick() {
        if (isFieldsNoEmpty() && isPasswordsEqual())
            ShowAlert()
        else if (!isFieldsNoEmpty())
            ShowAlert("Все поля должны быть заполнены")
        else
            ShowAlert("Пароли не совпадают")
    }

    private fun isPasswordsEqual(): Boolean {
        val password1 = findViewById<EditText>(R.id.password)
        val password2 = findViewById<EditText>(R.id.password2)
        return password1.text.toString() == password2.text.toString()
    }

    private fun isFieldsNoEmpty(): Boolean {
        val email = findViewById<EditText>(R.id.mail)
        val firstName = findViewById<EditText>(R.id.firstName)
        val lastName = findViewById<EditText>(R.id.lastName)
        val password1 = findViewById<EditText>(R.id.password)
        val password2 = findViewById<EditText>(R.id.password2)
        return email.text.isNotEmpty() && firstName.text.isNotEmpty() && lastName.text.isNotEmpty() && password1.text.isNotEmpty() && password2.text.isNotEmpty()
    }

    private fun ShowAlert(message: String = "") {
        val alert = findViewById<TextView>(R.id.alert)
        alert.text = message
    }
}