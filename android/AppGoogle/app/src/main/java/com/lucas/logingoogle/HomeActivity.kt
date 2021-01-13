package com.lucas.logingoogle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso

class HomeActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private val ivProfile: ImageView by lazy { findViewById<ImageView>(R.id.ivProfile) }
    private val tvId: TextView by lazy { findViewById<TextView>(R.id.tvId) }
    private val tvName: TextView by lazy { findViewById<TextView>(R.id.tvName) }
    private val tvEmail: TextView by lazy { findViewById<TextView>(R.id.tvEmail) }

    private val btnSignOut: Button by lazy { findViewById<Button>(R.id.btnSignOut) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser

        tvId.text = currentUser!!.uid
        tvName.text = currentUser.displayName
        tvEmail.text = currentUser.email

        Picasso.get()
            .load(auth.currentUser!!.photoUrl)
            .into(ivProfile)

        btnSignOut.setOnClickListener {
            auth.signOut()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}