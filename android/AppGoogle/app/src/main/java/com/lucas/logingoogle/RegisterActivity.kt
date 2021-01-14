package com.lucas.logingoogle

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth

        findViewById<Button>(R.id.btnCadastrar).setOnClickListener {
            val email = findViewById<EditText>(R.id.edtEmail).text.toString()
            val password = findViewById<EditText>(R.id.edtPassword).text.toString()
            val nome = findViewById<EditText>(R.id.edtNome).text.toString()

            val ehNovo = findViewById<Switch>(R.id.switchNovo).isChecked

            if (ehNovo) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val user = auth.currentUser

                            val profileUpdates = userProfileChangeRequest {
                                displayName = nome
                            }

                            user!!.updateProfile(profileUpdates).addOnCompleteListener {
                                Toast.makeText(
                                    baseContext, "Sucesso!!!",
                                    Toast.LENGTH_SHORT
                                ).show()

                                user!!.sendEmailVerification()
                                    .addOnCompleteListener { task ->
                                        if (task.isSuccessful) {

                                        }
                                    }
                            }

                            //updateUI(user)
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(
                                baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            } else {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                baseContext, "LOGOOUUU!!!",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                baseContext, "DEU ÁGUIA!!!",
                                Toast.LENGTH_SHORT
                            ).show()
                            // ...
                        }

                        // ...
                    }
            }
        }
    }
}