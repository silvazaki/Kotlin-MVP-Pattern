package com.github.kotlin_mvp_pattern.ui.splashscreen

import android.content.Intent
import android.os.Bundle

import com.github.kotlin_mvp_pattern.R
import com.github.kotlin_mvp_pattern.base.BaseActivity
import com.github.kotlin_mvp_pattern.ui.main.MainActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun setUp() {

    }

    override fun setActionListener() {

    }
}
