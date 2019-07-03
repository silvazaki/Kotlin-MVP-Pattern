package com.github.kotlin_mvp_pattern.base


import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.github.kotlin_mvp_pattern.App
import com.github.kotlin_mvp_pattern.data.Repository
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

abstract class BaseActivity : AppCompatActivity() {


    protected val repository: Repository?
        get() = (application as App).repository

    abstract fun setUp()

    abstract fun setActionListener()

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

}
