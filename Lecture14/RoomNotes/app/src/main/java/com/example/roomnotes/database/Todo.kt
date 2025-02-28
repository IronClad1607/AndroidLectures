package com.example.roomnotes.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(

    @PrimaryKey(autoGenerate = true)
    val id:Long? = null,
    val task: String,

    @ColumnInfo(name = "done")
    var status: Boolean
)