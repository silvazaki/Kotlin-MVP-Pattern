package com.github.kotlin_mvp_pattern

import android.app.Application

import com.github.kotlin_mvp_pattern.data.Repository

import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class App : Application() {

    internal var repository: Repository? = null

    override fun onCreate() {
        super.onCreate()

        repository = Repository(applicationContext)

        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Comfortaa-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )
    }

    fun getRepository(): Repository {
        if (repository == null)
            repository = Repository(applicationContext)
        return repository as Repository
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}
