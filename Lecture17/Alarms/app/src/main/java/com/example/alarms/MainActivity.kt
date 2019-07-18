package com.example.alarms

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {

    val am by lazy {
        getSystemService(Context.ALARM_SERVICE) as AlarmManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nonRepeatingAlarms()
    }

    fun repeatingAlarms() {
        val intent = Intent(this, MainActivity::class.java)

        val pi = PendingIntent.getActivities(this, 123, arrayOf(intent), PendingIntent.FLAG_UPDATE_CURRENT)

        val calendar = Calendar.getInstance()
        calendar.set(2019, 7, 18, 15,5)
        am.setRepeating(
            AlarmManager.RTC,
            System.currentTimeMillis() + 15000,
            AlarmManager.INTERVAL_DAY * 7,
            pi
        )
    }

    fun nonRepeatingAlarms() {
        val intent = Intent(this, MainActivity::class.java)

        val pi = PendingIntent.getActivities(this, 123, arrayOf(intent), PendingIntent.FLAG_UPDATE_CURRENT)

        val calendar = Calendar.getInstance()
        calendar.set(2019, 7, 18, 15,5)
        am.set(
            AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis() + 15000,
            pi
        )
    }
}
