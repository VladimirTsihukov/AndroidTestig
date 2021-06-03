package com.androidapp.testinghw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.androidapp.testinghw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val emailValidator = EmailValidator()
    private val passwordValidator = PasswordValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            emailInput.addTextChangedListener(emailValidator)
            passwordInput.addTextChangedListener(passwordValidator)

            saveButton.setOnClickListener {
                var isValidLogin = true
                if (!emailValidator.isValid) {
                    isValidLogin = false
                    emailInput.error = getString(R.string.invalid_email)
                }

                if (!passwordValidator.passwordIsValid) {
                    isValidLogin = false
                    passwordInput.error = getString(R.string.invalid_password)
                }
                if (isValidLogin) {
                    Toast.makeText(this@MainActivity, getString(R.string.valid_email), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}