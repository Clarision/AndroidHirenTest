package com.hiren.androidtest.ui.auth.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hiren.androidtest.R
import com.hiren.androidtest.databinding.ActivityHomeBinding
import com.hiren.androidtest.databinding.ActivityLoginBinding
import com.hiren.androidtest.ui.auth.viewmodel.HomeViewModel

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        val viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.setBinding(binding = binding)
        viewModel.setActivity(activity = this)
        viewModel.setUserName(intent.getStringExtra("userName")!!)
        binding.viewModel = viewModel
    }
}