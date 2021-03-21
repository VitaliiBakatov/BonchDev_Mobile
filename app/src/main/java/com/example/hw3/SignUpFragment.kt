package com.example.hw3

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw3.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.run {
            regBtn.setOnClickListener {
                onButtonClick()
            }
            textViewAccount.setOnClickListener {
                (requireActivity() as MainActivity).goToSignInFragment()
            }
        }
    }
    private fun onButtonClick() {
        if (isFieldsNoEmpty() && isPasswordsEqual()) {
            val message = "Успешная регистрация!"
            val user = User(binding.mail.text.toString(), binding.password.text.toString())
            startActivity(Intent(requireContext(), MainMenuActivity::class.java).apply {
                putExtra("user", user)
                putExtra("message", message)
            })
        }
        else if (!isFieldsNoEmpty()){
            val message = "Вы не заполнили поля:\n" + whatFieldsAreEmpty()
            showAlert("Все поля должны быть заполнены!", message)
        }
        else
            showAlert("Пароли не совпадают", "Пароли, которые вы ввели не совпадают, исправьте это!")
    }

    private fun isPasswordsEqual(): Boolean =
        binding.password.text.toString() == binding.password2.text.toString()


    private fun isFieldsNoEmpty(): Boolean {
        binding.run {
            return !mail.text.isNullOrEmpty() && firstName.text.isNotEmpty() && lastName.text.isNotEmpty() && password.text.isNotEmpty() && password2.text.isNotEmpty()
        }
    }

    private fun whatFieldsAreEmpty(): String {
        var fields = ""
        binding.run {
            if (mail.text.isNullOrEmpty())
                fields += "Email, "
            if (firstName.text.isNullOrEmpty())
                fields += "Имя, "
            if (lastName.text.isNullOrEmpty())
                fields += "Фамилия, "
            if (password.text.isNullOrEmpty())
                fields += "Пароль, "
            if (password2.text.isNullOrEmpty())
                fields += "Потверждение пароля"
        }
        return fields
    }

    private fun showAlert(title: String = "", message: String = "") {
        AlertDialog.Builder(requireContext())
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }.create().show()
    }

}