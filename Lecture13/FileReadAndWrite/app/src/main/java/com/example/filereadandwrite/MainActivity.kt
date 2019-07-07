package com.example.filereadandwrite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Log.d("FILES","Files dir = ${filesDir.path}")

        btnSave.setOnClickListener {
            val file = File(filesDir,"myfile.txt")
            Log.d("FILES","exists = ${file.exists()}")
        }

        btnRestore.setOnClickListener {


        }
    }
}
