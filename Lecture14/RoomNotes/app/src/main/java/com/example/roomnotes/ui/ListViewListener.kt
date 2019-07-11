package com.example.roomnotes.ui

import com.example.roomnotes.database.Todo

interface ListViewListener {
    fun checkboxClick(task: Todo, position: Int)
    fun btnDeleteClick(task: Todo, position: Int)
}