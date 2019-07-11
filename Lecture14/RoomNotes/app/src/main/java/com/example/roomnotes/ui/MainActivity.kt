package com.example.roomnotes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.roomnotes.R
import com.example.roomnotes.database.AppDatabase
import com.example.roomnotes.database.Todo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val db: AppDatabase by lazy {
        Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "todo.db"
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    var list = arrayListOf<Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = db.todoDao().getAllTodo() as ArrayList<Todo>

        val todoAdapter = TODOAdapter(list)
        lvTODO.adapter = todoAdapter


        btnADD.setOnClickListener {
            db.todoDao().insertRow(
                Todo(
                    task = etTask.text.toString(),
                    status = false
                )
            )

            etTask.text.clear()
            list = db.todoDao().getAllTodo() as ArrayList<Todo>
            todoAdapter.updateTasks(list)
        }


    }

}
