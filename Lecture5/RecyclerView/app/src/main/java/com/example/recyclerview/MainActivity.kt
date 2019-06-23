package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val courses = genNRandomCourse(200)

        rvCourses.layoutManager = GridLayoutManager(
            this,
            5,
            GridLayoutManager.HORIZONTAL,
            false
        )

        rvCourses.adapter = CourseAdapter(courses)
    }


}
