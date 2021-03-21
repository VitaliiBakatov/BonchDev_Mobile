package com.example.hw3

import java.io.Serializable

data class User(val email: String, val password: String) : Serializable {
    override fun toString(): String {
        return "Email: $email\nPassword: $password"
    }
}