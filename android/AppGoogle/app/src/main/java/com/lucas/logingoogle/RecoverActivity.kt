package com.lucas.logingoogle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RecoverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover)

        findViewById<Button>(R.id.btnEnviarLink).setOnClickListener {
            val email = findViewById<EditText>(R.id.edtEmailRecover).text.toString()

            Firebase.auth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    Toast.makeText(
                        baseContext, "Um e-mail foi enviado, verifique.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }
    }
}