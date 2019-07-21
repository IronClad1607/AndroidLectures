package com.example.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scheduleTask()
    }

    private fun scheduleTask() {
        val workerRequestWorker = OneTimeWorkRequestBuilder<NetworkRequestWorker>()
            .build()

        WorkManager.getInstance(this).enqueue(workerRequestWorker)
    }
}
