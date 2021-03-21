package com.example.hw3

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw3.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.run {
            loginBtn.setOnClickListener {
                onButtonClick()
            }
            textViewNoAccount.setOnClickListener {
                (requireActivity() as MainActivity).goToSignUpFragment()
            }
        }
    }

    private fun onButtonClick() {
        if (isFieldsNoEmpty()){
            val message = "Привет, рады снова тебя видеть!"
            val user = User(binding.mail.text.toString(), binding.password.text.toString())
            startActivity(Intent(requireContext(), MainMenuActivity::class.java).apply {
                putExtra("user", user)
                putExtra("message", message)
            })
        }

        else {
            val message = "Вы не заполнили поля:\n" + whatFieldsAreEmpty()
            showAlert("Все поля должны быть заполнены!", message)
        }
    }

    private fun isFieldsNoEmpty(): Boolean {
        binding.run {
            return mail.text.isNotEmpty() && password.text.isNotEmpty()
        }
    }

    private fun whatFieldsAreEmpty(): String {
        var fields = ""
        binding.run {
            if (mail.text.isNullOrEmpty())
                fields += "Email, "
            if (password.text.isNullOrEmpty())
                fields += "Пароль"
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