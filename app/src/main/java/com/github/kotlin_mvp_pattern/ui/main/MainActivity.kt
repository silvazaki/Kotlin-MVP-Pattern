package com.github.kotlin_mvp_pattern.ui.main

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.github.kotlin_mvp_pattern.R
import com.github.kotlin_mvp_pattern.base.BaseActivity
import com.github.kotlin_mvp_pattern.data.model.MovieItems
import com.github.kotlin_mvp_pattern.utils.Callback
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, MainMVP.View {

    lateinit var movieAdapter: MovieAdapter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUp()
        setActionListener()

        presenter!!.loadData()
    }


    override fun setUp() {
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view!!.setNavigationItemSelectedListener(this)

        presenter = MainPresenter(repository!!, this)
        movieAdapter = MovieAdapter(this)
        rv_nowplaying!!.layoutManager = LinearLayoutManager(this)
        rv_nowplaying!!.adapter = movieAdapter
    }

    override fun setActionListener() {
        movieAdapter.setViewCallback(object : Callback.ViewCallback {
            override fun onClick(position: Int, view: View) {
                Toast.makeText(applicationContext, position.toString(), Toast.LENGTH_SHORT).show()
            }
        })
//        movieAdapter.setItemCallback(object : Callback.ItemCallback {
//            override fun onBindView(holder: MovieAdapter.MovieHolder, position: Int) {
//                holder.imgCover.setOnClickListener {
//                    Toast.makeText(applicationContext, position.toString(), Toast.LENGTH_SHORT).show()
//                }
//            }
//
//        })
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_search) {
            true
        } else super.onOptionsItemSelected(item)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun showLoading(isLoading: Boolean) {

    }

    override fun showError(message: String) {

    }

    override fun upDateList(movieItems: List<MovieItems>) {
        movieAdapter!!.updateData(movieItems)
    }
}
