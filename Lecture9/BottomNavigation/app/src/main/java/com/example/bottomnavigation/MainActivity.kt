package com.example.bottomnavigation

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.navigation_home -> {
            supportFragmentManager.beginTransaction().replace(R.id.container,BlankFragment()).commit()
            true
        }
        R.id.navigation_dashboard -> {
            supportFragmentManager.beginTransaction().replace(R.id.container,BlankFragment2()).commit()
            true
        }
        R.id.navigation_notifications -> {
            supportFragmentManager.beginTransaction().replace(R.id.container,BlankFragment()).commit()
            true
        }

        else -> false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nav_view.setOnNavigationItemSelectedListener(this)
    }
}
