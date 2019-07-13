package com.example.firebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.firebase.FirebaseException
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    val auth by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(p0: PhoneAuthCredential?) {
                Toast.makeText(this@MainActivity, "Verification Completed", Toast.LENGTH_LONG).show()
                signUpWithPhone(p0)
            }

            override fun onVerificationFailed(p0: FirebaseException?) {
                Toast.makeText(this@MainActivity, "Exception Completed ${p0?.localizedMessage}", Toast.LENGTH_LONG)
                    .show()
            }

            override fun onCodeSent(p0: String?, p1: PhoneAuthProvider.ForceResendingToken?) {
                super.onCodeSent(p0, p1)
                Toast.makeText(this@MainActivity, "Code Sent Completed", Toast.LENGTH_LONG).show()

            }

        }

        btnSignIn.setOnClickListener {
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91${etEmail.text}", // Phone number to verify
                60, // Timeout duration
                TimeUnit.SECONDS, // Unit of timeout
                this, // Activity (for callback binding)
                callbacks
            ) // OnVerificationStateChangedCallback
        }


//        btnSignOut.setOnClickListener {
//            auth.signOut()
//            btnSignIn.isEnabled = true
//            Toast.makeText(this, "Signed Out", Toast.LENGTH_SHORT).show()
//        }
//
//        if (auth.currentUser != null) {
//
//            btnSignOut.isVisible = true
//            btnSignIn.setOnClickListener {
//                auth.signInWithEmailAndPassword(etEmail.text.toString(), etPassword.text.toString())
//                    .addOnCompleteListener {
//                        btnSignIn.isEnabled = false
//                    }
//                    .addOnSuccessListener {
//                        btnSignIn.isEnabled = true
//                        Toast.makeText(this, "Signed In Succesfully", Toast.LENGTH_LONG).show()
//                    }
//                    .addOnFailureListener {
//                        Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
//
//                    }
//            }
//
//
//
//
//        } else {
//            btnSignIn.setOnClickListener {
//
//                auth.createUserWithEmailAndPassword(etEmail.text.toString(), etPassword.text.toString())
//                    .addOnCompleteListener {
//                        btnSignIn.isEnabled = false
//                    }
//                    .addOnSuccessListener {
//                        btnSignIn.isEnabled = true
//                        Toast.makeText(this, "Signed In Succesfully", Toast.LENGTH_LONG).show()
//                    }
//                    .addOnFailureListener {
//                        Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
//                        if (it.localizedMessage.contains("use")) {
//                            auth.signInWithEmailAndPassword(etEmail.text.toString(), etPassword.text.toString())
//                                .addOnCompleteListener {
//                                    btnSignIn.isEnabled = false
//                                }
//                                .addOnSuccessListener {
//                                    btnSignIn.isEnabled = true
//                                    Toast.makeText(this, "Signed In Succesfully", Toast.LENGTH_LONG).show()
//                                }
//                                .addOnFailureListener {
//                                    Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
//
//                                }
//
//                            btnSignOut.isVisible = true
//
//                        }
//
//                    }
//            }
//        }
    }

    private fun signUpWithPhone(p0: PhoneAuthCredential?) {
        if (p0 != null) {
            auth.signInWithCredential(p0)
                .addOnCompleteListener {

                }.addOnSuccessListener {

                }.addOnFailureListener {

                }
        }

    }
}

