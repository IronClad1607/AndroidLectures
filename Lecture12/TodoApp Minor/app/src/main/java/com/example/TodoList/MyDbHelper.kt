package com.example.TodoList

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

const val DB_NAME = "tasks.db"
const val DB_VER = 1

class MyDbHelper(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, DB_VER) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.apply {
            execSQL(TasksTable.CMD_CREATE_TABLE)
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }
}