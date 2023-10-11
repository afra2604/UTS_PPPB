package com.example.uts_pppb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import com.example.uts_pppb.databinding.ActivityMainBinding

import java.text.SimpleDateFormat
import java.util.Date


class MainActivity : AppCompatActivity() {
    private lateinit var timeNow: TextView
    private lateinit var dateNow: TextView
    private lateinit var binding: ActivityMainBinding
    private lateinit var txtHalo: TextView
    private lateinit var bbNow: TextView
    private lateinit var bbTarget: TextView
    private lateinit var cardTujuan: TextView
    private lateinit var cardTanggalTercapai: TextView
    private lateinit var cardKalori: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        timeNow = findViewById(R.id.time_now)
        dateNow = findViewById(R.id.date_now)
        txtHalo = findViewById(R.id.txt_halo)
        bbNow = findViewById(R.id.bb_now)
        bbTarget = findViewById(R.id.bb_target)
        cardTujuan = findViewById(R.id.card_tujuan)
        cardTanggalTercapai = findViewById(R.id.card_tanggal_tercapai)
        cardKalori = findViewById(R.id.card_kalori)

        val currentTime = Date()

        // Mengformat waktu sesuai dengan format yang diinginkan
        val timeFormat = SimpleDateFormat("HH:mm")
        val dateFormat = SimpleDateFormat("dd-MM-yyyy")

        val formattedTime = timeFormat.format(currentTime)
        val formattedDate = dateFormat.format(currentTime)
        val nama = intent.getStringExtra("nama")
        val beratBadanSekarang = intent.getStringExtra("beratBadanSekarang")
        val beratBadanTarget = intent.getStringExtra("beratBadanTarget")
        val tujuanDiet = intent.getStringExtra("tujuanDiet")
        val kaloriHarian = intent.getStringExtra("kaloriHarian")
        val tanggalTarget = intent.getStringExtra("tanggalTarget")
        val spinnerBbNow = intent.getStringExtra("spinnerBbNow")
        val spinnerBbTarget = intent.getStringExtra("spinnerBbTarget")
""
        // Menampilkan  yang diformat dalam TextView

        with(binding) {

            binding.timeNow.text = "$formattedTime"
            binding.dateNow.text = "$formattedDate"
            binding.txtHalo.text = "Halo, $nama !"
            binding.bbNow.text = "Berat badan saat ini : $beratBadanSekarang $spinnerBbNow"
            binding.bbTarget.text = "Target berat badan : $beratBadanTarget $spinnerBbTarget"
            binding.cardTujuan.text = "Tujuan diet : $tujuanDiet"
            binding.cardTanggalTercapai.text = "Tanggal tercapai : $tanggalTarget"
            binding.cardKalori.text = "Kalori harian : $kaloriHarian"

            btnInputData.setOnClickListener{
                val intent = Intent (this@MainActivity, InputDataActivity::class.java)

            }

        }

    }

}