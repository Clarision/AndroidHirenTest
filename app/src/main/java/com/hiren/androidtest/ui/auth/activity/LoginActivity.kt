package com.hiren.androidtest.ui.auth.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hiren.androidtest.R
import com.hiren.androidtest.databinding.ActivityLoginBinding
import com.hiren.androidtest.ui.auth.viewmodel.HomeViewModel
import com.hiren.androidtest.ui.auth.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel.setBinding(binding = binding)
        viewModel.setActivity(activity = this)
        binding.viewModel = viewModel
    }
}