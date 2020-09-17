package com.example.study.ui

import android.os.Bundle
import androidx.activity.viewModels
import com.example.study.R
import com.example.study.base.BaseActivity
import com.example.study.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(
    layoutId = R.layout.activity_main
) {

    private val testViewModel by viewModels<TestViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = this@MainActivity.testViewModel

    }
}
