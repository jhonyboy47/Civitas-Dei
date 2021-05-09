package com.csci448.malagon.civitasdei

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val image: ImageView = findViewById(R.id.splash_image_view)
        image.alpha = 0f

        image.animate().setDuration(1500).alpha(1f).withEndAction {
            val login = Intent(this,RegistrationActivity::class.java)
            startActivity(login)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}