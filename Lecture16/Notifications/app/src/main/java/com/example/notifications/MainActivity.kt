package com.example.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            nm.createNotificationChannel(
                    NotificationChannel(
                            "first",
                            "default",
                            NotificationManager.IMPORTANCE_DEFAULT
                    )
            )
        }
        btn1.setOnClickListener {
            val simpleNotification = NotificationCompat.Builder(this, "first")
                    .setContentTitle("Simple Title")
                    .setContentText("This id simple content of a simple notifications")
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .build()

            val simpleNotification2 = NotificationCompat.Builder(this, "first")
                    .setContentTitle("Simple Title 2")
                    .setContentText("This id simple content of a simple notifications second time")
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .build()


            nm.notify(1, simpleNotification)

            nm.notify(2, simpleNotification2)
        }

        btn2.setOnClickListener {


            val i = Intent()
            i.action = Intent.ACTION_VIEW
            i.data = Uri.parse("https://www.google.com")
            val pi = PendingIntent.getActivity(this, 111, i, PendingIntent.FLAG_UPDATE_CURRENT)

            val clickNotification = NotificationCompat.Builder(this, "first")
                    .setContentTitle("Simple Title")
                    .setContentText("This id simple content of a simple notifications")
                    .setContentIntent(pi)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .build()

            nm.notify(3, clickNotification)
        }


        btn3.setOnClickListener {
            val i = Intent()
            i.action = Intent.ACTION_VIEW
            i.data = Uri.parse("https://www.google.com")
            val pi = PendingIntent.getActivity(this, 111, i, PendingIntent.FLAG_UPDATE_CURRENT)

            val actionNotification = NotificationCompat.Builder(this, "first")
                    .setContentTitle("Simple Title")
                    .setContentText("This id simple content of a simple notifications")
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .addAction(R.drawable.ic_launcher_foreground, "Click", pi)
                    .setPriority(NotificationCompat.PRIORITY_MAX)
                    .build()

            nm.notify(4,actionNotification)
        }
    }
}
