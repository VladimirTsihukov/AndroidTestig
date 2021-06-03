package com.androidapp.testinghw

import android.text.Editable
import android.text.TextWatcher
import java.util.regex.Pattern

class PasswordValidator : TextWatcher {

    var passwordIsValid = false

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit

    override fun afterTextChanged(s: Editable?) {
        passwordIsValid = passwordIsValid(s)
    }

    companion object {

        private val PASSWORD_PATTERN = Pattern.compile(
            ".{7,256}"
        )

        fun passwordIsValid(password: CharSequence?) : Boolean {
            return password != null && PASSWORD_PATTERN.matcher(password).matches()
        }
    }
}