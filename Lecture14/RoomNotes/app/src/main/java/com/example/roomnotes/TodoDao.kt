package com.example.roomnotes

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

interface TodoDao {
    @Insert
    fun insertRow(todo: Todo)

    @Insert
    fun insertAll(todoList: ArrayList<Todo>)


    @Query("SELECT * FROM todo")
    fun getAllTodo(): List<Todo>

    @Query("SELECT * FROM todo WHERE task = :task")
    fun getAllTodoWithDone(task: String)

    @Delete
    fun delete(todo: Todo)
}