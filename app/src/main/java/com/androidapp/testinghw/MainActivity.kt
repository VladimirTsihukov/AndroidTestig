package com.androidapp.testinghw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.androidapp.testinghw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val emailValidator = EmailValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            emailInput.addTextChangedListener(emailValidator)

            saveButton.setOnClickListener {
                if (emailValidator.isValid) {
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.valid_email),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val error = getString(R.string.invalid_email)
                    emailInput.error = error
                    Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}