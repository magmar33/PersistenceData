package com.example.persistencedata.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.persistencedata.R
import com.example.persistencedata.presentation.login.LoginActivity

class SplashActivity : AppCompatActivity(){
    private lateinit var imgSplash : LottieAnimationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        imgSplash = findViewById(R.id.imgSplash)

        imgSplash.apply {
            alpha = 0F
            animate().setDuration(1500L).alpha(1F).withEndAction{
                startActivity(Intent(this@SplashActivity,LoginActivity::class.java))
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
                finish()
            }
        }
    }
}