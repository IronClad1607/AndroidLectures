package com.example.shared

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val KEY_DATA = "data"
    val KEY_OPEN_COUNT = "app_open"
    var appOpenCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs = getPreferences(Context.MODE_PRIVATE)

        appOpenCount = prefs.getInt(KEY_OPEN_COUNT,0)
        appOpenCount++

        prefs.edit{
            putInt(KEY_OPEN_COUNT,appOpenCount)
        }

        tvOpenCount.text = appOpenCount.toString()

        btnSave.setOnClickListener {
            prefs.edit{
                putString(KEY_DATA, etData.text.toString())
            }
        }

        btnRestore.setOnClickListener {
            val data = prefs.getString(KEY_DATA,"")
            etData.setText(data)
        }
    }
}
