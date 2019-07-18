package com.example.databasefirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val auth by lazy {
        FirebaseAuth.getInstance()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        FirebaseDatabase.getInstance().reference.child("messages")
//            .child("user1")
//            .child("chat")
//            .child("Time")
//            .addValueEventListener(object : ValueEventListener{
//                override fun onCancelled(p0: DatabaseError) {
//
//                }
//
//                override fun onDataChange(p0: DataSnapshot) {
//                    text.text = p0.value.toString()
//                }
//
//            })

        val list = arrayListOf<Chat>()
        FirebaseDatabase.getInstance().reference.child("messages")
            .child("user1")
            .addChildEventListener(object : ChildEventListener{
                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onChildMoved(p0: DataSnapshot, p1: String?) {
                }

                override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                }

                override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                    val result = p0.getValue(Chat::class.java)
                    result?.let {
                        list.add(it)
                    }
                    list.forEach {
                        text.text = "${text.text} ${it.text}"
                    }
                }

                override fun onChildRemoved(p0: DataSnapshot) {
                }

            })

//        FirebaseDatabase.getInstance().reference.child("messages/user1/chat1/text")
//            .setValue("New Text Set")

        val chat = Chat()
        chat.text = "New Text Added"
        chat.Time = "12 PM"

        val ref = FirebaseDatabase.getInstance().reference.child("messages/user1/")
        val key = ref.push().key
        ref.child("$key/")
            .setValue(chat)

    }
}

class Chat {
    var text : String = ""
    var Time : String = ""
}
