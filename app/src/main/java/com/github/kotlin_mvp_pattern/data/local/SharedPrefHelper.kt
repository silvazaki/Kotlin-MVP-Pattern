package com.github.kotlin_mvp_pattern.data.local

import android.content.Context
import android.content.SharedPreferences

class SharedPrefHelper(context: Context) {

    private val MLIB_PREF = "mvp"

    private val mPreferences: SharedPreferences

    init {
        mPreferences = context.getSharedPreferences(MLIB_PREF, Context.MODE_PRIVATE)
    }

    fun getString(key: String): String? {
        return mPreferences.getString(key, null)
    }

    fun getInt(key: String): Int {
        return mPreferences.getInt(key, 0)
    }

    fun putString(key: String, value: String) {
        mPreferences.edit().putString(key, value).apply()
    }

    fun putInt(key: String, value: Int) {
        mPreferences.edit().putInt(key, value).apply()
    }

    fun clear() {
        mPreferences.edit().clear().apply()
    }

}
