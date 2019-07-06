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

    val todoArray = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoArray.clear()



        val todoAdapter = TaskAdapter(this,todoArray)
        lvTODO.adapter = todoAdapter

        btnADD.setOnClickListener {
            val task = etTask.text.toString()
            if (task.isNotEmpty()) {
                todoArray.add(task)
                etTask.text.clear()
                todoAdapter.notifyDataSetChanged()
            }
        }

        lvTODO.setOnItemClickListener { adapterView, view, i, l ->
            todoArray.removeAt(i)
            todoAdapter.notifyDataSetChanged()

        }


    }


    class TaskAdapter(val context: Context, val taskList: ArrayList<String>) : BaseAdapter() {
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

            val li = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val itemView = p1 ?: li.inflate(R.layout.list_task, p2, false)


            val task = taskList[p0]

            with(itemView) {
                tvTask.text = task
            }

           return itemView
        }

        override fun getItem(p0: Int): Any? {
            return null
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        override fun getCount() = taskList.size

    }
}
