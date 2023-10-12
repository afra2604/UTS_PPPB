package com.example.uts_pppb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.uts_pppb.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {
    //untuk deklarasi berapa lama timer splash screen muncul
    private lateinit var binding: ActivitySplashBinding
    private val SPLASH_TIME_OUT:Long = 3000 //3 Detik

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //kode untuk menjalankan main screen setelah timer splash screen habis
        Handler().postDelayed({
            startActivity(Intent(this, WelcomingActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)


    }
}