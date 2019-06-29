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
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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
            Toast.makeText(this, "Drop 1", Toast.LENGTH_LONG).show()
            true
        }
        R.id.button2 -> {
            Toast.makeText(this, "Drop 2", Toast.LENGTH_LONG).show()
            true
        }
        R.id.button3->{
            Toast.makeText(this, "Copied", Toast.LENGTH_LONG).show()
            true
        }
        R.id.button4->{
            Toast.makeText(this, "Info Button", Toast.LENGTH_LONG).show()
            true
        }
        R.id.button5->{
            Toast.makeText(this, "Blocked", Toast.LENGTH_LONG).show()
            true
        }

        android.R.id.home ->{
            finish()
            true
        }
        else -> super.onOptionsItemSelected(item)

    }
}
