package com.systems.unittesting.utils

object FieldValidation {

    private const val EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    /*
    return false if
    email is empty or
    password is empty or
    password is not greater than 6 characters and email is not valid
    */

    fun isValidLoginFields(email: String, password: String): Boolean {
        if (email.isEmpty()) return false
        if (password.isEmpty()) return false
        return password.length >= 6 && email.matches(EMAIL_PATTERN.toRegex())
    }
}