package com.digitalhouse.splashdemo

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.TextView

const val DURACAO_DO_SPLASH = 4000L // L de Long

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        colocarActivityEmFullScreen() // plus

        setContentView(R.layout.activity_splash)

        animaTexto() // plus do plus

        // Inicia a MainActivity após 4 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, DURACAO_DO_SPLASH)
    }

    private fun animaTexto() {
        val appName = findViewById<TextView>(R.id.appName)
        appName.alpha = 0f
        appName.y = 1000f
        appName.scaleX = 0.1f
        appName.scaleY = 0.1f

        appName.animate()
            .alpha(1f)
            .y(800f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(1500)
            .setListener(null)
    }

    @Suppress("DEPRECATION")
    private fun colocarActivityEmFullScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }
}