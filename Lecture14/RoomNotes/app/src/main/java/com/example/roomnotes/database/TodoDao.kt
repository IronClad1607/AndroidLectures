package com.example.roomnotes.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {
    @Insert
    fun insertRow(todo: Todo)

    @Insert
    fun insertAll(todoList: ArrayList<Todo>)


    @Query("SELECT * FROM todo")
    fun getAllTodo(): LiveData<List<Todo>>

    @Query("SELECT * FROM todo WHERE task = :task")
    fun getAllTodoWithDone(task: String)

    @Delete
    fun delete(todo: Todo)
}