package com.example.githubuserinfo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubuserinfo.R
import com.example.githubuserinfo.base.BaseActivity
import com.example.githubuserinfo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_main
}