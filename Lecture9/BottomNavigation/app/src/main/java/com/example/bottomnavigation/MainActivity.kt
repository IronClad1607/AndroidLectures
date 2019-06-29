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
            textView1.setText(R.string.title_home)
            true
        }
        R.id.navigation_dashboard -> {
            textView1.setText(R.string.title_dashboard)
            true
        }
        R.id.navigation_notifications -> {
            textView1.setText(R.string.title_notifications)
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
