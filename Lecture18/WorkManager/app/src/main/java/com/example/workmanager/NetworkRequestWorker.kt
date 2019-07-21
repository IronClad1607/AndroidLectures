package com.example.workmanager

import android.content.Context
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters

class NetworkRequestWorker(val context: Context,workerParameters: WorkerParameters) :Worker(context,workerParameters){
    override fun doWork(): Result {
        Toast.makeText(context,"Job Is Working",Toast.LENGTH_LONG).show()

        return Result.success()
    }

}