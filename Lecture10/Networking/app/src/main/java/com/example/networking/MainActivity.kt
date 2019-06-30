package com.example.networking

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val networkTask = NetworkTask()
        networkTask.execute("https://api.github.com/search/users?q=Ishaan%20Jain")
    }

    inner class NetworkTask : AsyncTask<String, Int, String>() {
        override fun onPostExecute(result: String?) {

            val jsonData = JSONObject(result)
            val userList = jsonData.getJSONArray("items")
            val currentUser = userList[0] as JSONObject
            showData.text = currentUser.getString("login")
        }

        override fun doInBackground(vararg urls: String?): String {
            val googleUrl: URL = URL(urls[0])
            val connection = googleUrl.openConnection() as HttpURLConnection
            val isr = InputStreamReader(connection.inputStream)
            val bufferReader = BufferedReader(isr)
            val sb = StringBuilder()
            var buffer: String? = ""
            while (buffer != null) {
                sb.append(buffer)
                buffer = bufferReader.readLine()
            }

            return sb.toString()
        }
    }
}
