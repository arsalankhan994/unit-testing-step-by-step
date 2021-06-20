package com.erselan.unittesting.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.erselan.unittesting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setListener()
    }

    private fun setListener() {
        binding.apply {

            login.setOnClickListener {
                validateFields(binding.email.text.toString(), binding.password.text.toString())
            }
        }
    }

    private fun validateFields(emailAddress: String, password: String) {

    }
}