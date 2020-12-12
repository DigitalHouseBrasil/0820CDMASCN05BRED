package com.lucas.facebookapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private val button: Button by lazy { findViewById<Button>(R.id.login_button) }
    private lateinit var callbackManager: CallbackManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callbackManager = CallbackManager.Factory.create()

        button.setOnClickListener { loginFacebook() }
    }

    private fun irParaHome(uiid: String) {
        AppUtil.salvarIdUsuario(application.applicationContext, uiid)
        startActivity(Intent(applicationContext, HomeActivity::class.java))
        finish()
    }

    private fun loginFacebook() {
        val instanceFirebase = LoginManager.getInstance()

        instanceFirebase.logInWithReadPermissions(this, listOf("email", "public_profile"))
        instanceFirebase.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {

                override fun onSuccess(loginResult: LoginResult) {
                    val credential: AuthCredential = FacebookAuthProvider.getCredential(loginResult.accessToken.token)
                    FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener { irParaHome(loginResult.accessToken.userId) }
                }

                override fun onCancel() {
                    Toast.makeText(this@MainActivity, "Cancelado!", Toast.LENGTH_SHORT).show()
                }

                override fun onError(error: FacebookException) {
                    Toast.makeText(this@MainActivity, error.message, Toast.LENGTH_SHORT).show()
                }
            })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }
}