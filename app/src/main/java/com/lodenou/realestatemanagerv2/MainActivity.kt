package com.lodenou.realestatemanagerv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {

    private var mDrawerLayout:DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDrawer()
    }

    private fun initDrawer() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val mDrawerLayout:DrawerLayout = findViewById(R.id.drawer_layout)

        val mActionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            mDrawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
            )
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle)
        mActionBarDrawerToggle.syncState()
    }

    @Override
    // don't leave the activity immediately when pressed back btn when navdrawer is open
    override fun onBackPressed(){
        if (mDrawerLayout?.isDrawerOpen(GravityCompat.START) == true)
            mDrawerLayout?.closeDrawer(GravityCompat.START)
        else
        super.onBackPressed()
    }
}