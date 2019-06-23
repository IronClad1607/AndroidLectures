package com.example.marvelvsdc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMarvel.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("NAME","DC")
            val frag = FragmentDC()
            frag.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.container,FragmentMarvel()).commit()
        }

    }
}
