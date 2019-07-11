package com.example.roomnotes.ui

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import com.example.roomnotes.R
import com.example.roomnotes.database.Todo

class TODOAdapter(var tasks: ArrayList<Todo>) : BaseAdapter() {

    var listItemClickListener: ListViewListener? = null

    fun updateTasks(newTasks: ArrayList<Todo>) {
        tasks.clear()
        tasks.addAll(newTasks)
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val li = parent!!.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = convertView ?: li.inflate(R.layout.list_todo, parent, false)

        view.findViewById<TextView>(R.id.tvTask).text = getItem(position).task

        if (getItem(position).status) {
            view.findViewById<TextView>(R.id.tvTask).setTextColor(Color.RED)
            view.findViewById<CheckBox>(R.id.cbDone).isChecked = true
        } else {
            view.findViewById<TextView>(R.id.tvTask).setTextColor(Color.BLACK)
            view.findViewById<CheckBox>(R.id.cbDone).isChecked = false
        }

        view.findViewById<Button>(R.id.btnCross).setOnClickListener {
            listItemClickListener?.btnDeleteClick(getItem(position), position)
        }

        view.findViewById<CheckBox>(R.id.cbDone).setOnClickListener {

            listItemClickListener?.checkboxClick(getItem(position), position)
        }
        return view
    }

    override fun getItem(position: Int): Todo = tasks[position]

    override fun getItemId(position: Int): Long = 0

    override fun getCount(): Int = tasks.size

}