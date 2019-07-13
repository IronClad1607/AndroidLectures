package com.example.firebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val auth by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (auth.currentUser != null) {

            btnSignOut.isVisible = true
            btnSignIn.setOnClickListener {
                auth.signInWithEmailAndPassword(etEmail.text.toString(), etPassword.text.toString())
                    .addOnCompleteListener {
                        btnSignIn.isEnabled = false
                    }
                    .addOnSuccessListener {
                        btnSignIn.isEnabled = true
                        Toast.makeText(this, "Signed In Succesfully", Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()

                    }
            }
            btnSignOut.setOnClickListener {
                auth.signOut()
                Toast.makeText(this, "Signed Out", Toast.LENGTH_SHORT).show()
            }
        } else {
            btnSignIn.setOnClickListener {

                auth.createUserWithEmailAndPassword(etEmail.text.toString(), etPassword.text.toString())
                    .addOnCompleteListener {
                        btnSignIn.isEnabled = false
                    }
                    .addOnSuccessListener {
                        btnSignIn.isEnabled = true
                        Toast.makeText(this, "Signed In Succesfully", Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
                        if (it.localizedMessage.contains("use")) {
                            auth.signInWithEmailAndPassword(etEmail.text.toString(), etPassword.text.toString())
                                .addOnCompleteListener {
                                    btnSignIn.isEnabled = false
                                }
                                .addOnSuccessListener {
                                    btnSignIn.isEnabled = true
                                    Toast.makeText(this, "Signed In Succesfully", Toast.LENGTH_LONG).show()
                                }
                                .addOnFailureListener {
                                    Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()

                                }
                        }

                    }
            }
        }
    }
}
