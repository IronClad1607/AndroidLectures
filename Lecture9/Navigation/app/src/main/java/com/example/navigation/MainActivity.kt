package com.example.navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbaar)
        supportActionBar?.title = "Hello World"

        btnChangeActivity.setOnClickListener {
            startActivity(Intent(this@MainActivity, Main2Activity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.button1 -> {
            Toast.makeText(this, "Toolbar Button", Toast.LENGTH_LONG).show()
            true
        }
        else -> super.onOptionsItemSelected(item)

    }
}
