package com.example.TodoList

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_task.view.*

class MainActivity : AppCompatActivity() {

    var tasks = arrayListOf<TasksTable.Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val dbHelper = MyDbHelper(this)

        val tasksDb = dbHelper.writableDatabase

        tasks = TasksTable.getAllTasks(tasksDb)



        val todoAdapter = TaskAdapter(tasks)
        lvTODO.adapter = todoAdapter

        btnADD.setOnClickListener {
            TasksTable.insertTasks(
                tasksDb,
                TasksTable.Task(
                    null,
                    etTask.text.toString(),
                    false
                )
            )
            tasks = TasksTable.getAllTasks(tasksDb)
            todoAdapter.updateTasks(tasks)

        }

//        lvTODO.setOnItemClickListener { adapterView, view, i, l ->
//            tasks.removeAt(i)
//            todoAdapter.notifyDataSetChanged()
//
//        }


    }


    class TaskAdapter(val taskList: ArrayList<TasksTable.Task>) : BaseAdapter() {

        fun updateTasks(newTasks: ArrayList<TasksTable.Task>) {
            taskList.clear()
            taskList.addAll(newTasks)
            notifyDataSetChanged()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

            val li = p2!!.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val itemView = p1 ?: li.inflate(R.layout.list_task, p2, false)


            val task = taskList[p0]

            with(itemView) {
                tvTask.text = getItem(p0).task
            }

           return itemView
        }

        override fun getItem(p0: Int): TasksTable.Task = taskList[p0]

        override fun getItemId(p0: Int): Long {
            return 0
        }

        override fun getCount() = taskList.size

    }
}
