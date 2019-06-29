package com.example.bottomnavigation

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_blank.*

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
            Snackbar.make(container,"SnackBar Displayed",Snackbar.LENGTH_SHORT).show()
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
