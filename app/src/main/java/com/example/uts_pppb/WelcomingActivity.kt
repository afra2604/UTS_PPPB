package com.example.uts_pppb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.uts_pppb.databinding.ActivityWelcomingBinding

class WelcomingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonMulai = findViewById<Button>(R.id.buttonMulai)

        buttonMulai.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, GetStartedActivity::class.java)

            startActivity(intent)
        })
    }
}