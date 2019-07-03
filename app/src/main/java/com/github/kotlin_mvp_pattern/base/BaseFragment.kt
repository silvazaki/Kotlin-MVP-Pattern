package com.github.kotlin_mvp_pattern.base


import android.support.v4.app.Fragment
import com.github.kotlin_mvp_pattern.App
import com.github.kotlin_mvp_pattern.data.Repository

abstract class BaseFragment : Fragment() {

    protected val repository: Repository?
        get() = (activity!!.application as App).repository

}
