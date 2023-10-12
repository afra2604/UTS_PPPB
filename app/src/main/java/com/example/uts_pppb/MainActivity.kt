package com.example.uts_pppb

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
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
    private lateinit var txtKaloriMasuk: TextView
    private lateinit var txtKaloriKeluar: TextView
    private lateinit var txtSisaKalori: TextView

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result ->
            if (result.resultCode== Activity.RESULT_OK){
                val data = result.data
                val nama = data?.getStringExtra("nama")
                val beratBadanSekarang = data?.getStringExtra("beratBadanSekarang")
                val spinnerBbNow = data?.getStringExtra("spinnerBbNow")
                val beratBadanTarget = data?.getStringExtra("beratBadanTarget")
                val spinnerBbTarget = data?.getStringExtra("spinnerBbTarget")
                val tujuanDiet = data?.getStringExtra("tujuanDiet")
                val tanggalTarget = data?.getStringExtra("tanggalTarget")
                val kaloriHarian = data?.getStringExtra("kaloriHarian")


                binding.txtHalo.text = "Halo, $nama !"
                binding.bbNow.text = "Berat badan saat ini : $beratBadanSekarang $spinnerBbNow"
                binding.bbTarget.text = "Target berat badan : $beratBadanTarget $spinnerBbTarget"
                binding.cardTujuan.text = "Tujuan diet : $tujuanDiet"
                binding.cardTanggalTercapai.text = "Tanggal tercapai : $tanggalTarget"
                binding.cardKalori.text = "Kalori harian : $kaloriHarian"

                //untuk mengambil data yang sudah masuk

            }

        }

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
        txtKaloriMasuk = findViewById(R.id.txt_kalori_in_terakhir)
        txtKaloriKeluar = findViewById(R.id.txt_kalori_keluar_terakhir)

        val currentTime = Date()

        // Mengformat waktu sesuai dengan format yang diinginkan
        val timeFormat = SimpleDateFormat("HH:mm")
        val dateFormat = SimpleDateFormat("dd-MM-yyyy")

        val formattedTime = timeFormat.format(currentTime)
        val formattedDate = dateFormat.format(currentTime)

        // Menampilkan  yang diformat dalam TextView
//menjadikan string
        val sharedPreferences = getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE)
        val nama = sharedPreferences.getString("nama","")
        val beratBadanSekarang = sharedPreferences.getString("beratBadanSekarang","")
        val beratBadanTarget = sharedPreferences.getString("beratBadanTarget","")
        val tujuanDiet = sharedPreferences.getString("tujuanDiet","")
        val kaloriHarian = sharedPreferences.getString("kaloriHarian","")
        val tanggalTarget = sharedPreferences.getString("tanggalTarget","")
        val spinnerBbNow = sharedPreferences.getString("spinnerBbNow","")
        val spinnerBbTarget = sharedPreferences.getString("spinnerBbTarget","")

        val kaloriMasuk = sharedPreferences.getString("kaloriMasuk","0")
        val kaloriKeluar = sharedPreferences.getString("kaloriKeluar","0")

        val btnInputData = findViewById<Button>(R.id.btn_input_data)
        val btnHome = findViewById<Button>(R.id.btn_home)

        with(binding) {

            binding.timeNow.text = "$formattedTime"
            binding.dateNow.text = "$formattedDate"
            binding.txtHalo.text = "Halo, $nama !"
            binding.bbNow.text = "Berat badan saat ini : $beratBadanSekarang $spinnerBbNow"
            binding.bbTarget.text = "Target berat badan : $beratBadanTarget $spinnerBbTarget"
            binding.cardTujuan.text = "Tujuan diet : $tujuanDiet"
            binding.cardTanggalTercapai.text = "Tanggal tercapai : $tanggalTarget"
            binding.cardKalori.text = "Kalori harian : $kaloriHarian"
            binding.txtKaloriInTerakhir.text = "Kalori Terakhir Masuk : " + kaloriMasuk
            binding.txtKaloriKeluarTerakhir.text = "Kalori Terakhir Keluar : " + kaloriKeluar

            btnInputData.setOnClickListener{

                val intent = Intent(this@MainActivity, InputDataActivity::class.java)
                launcher.launch(intent)
                finish()
                    }
            btnHome.setOnClickListener{
                val editor = sharedPreferences.edit()
                editor.clear()
                editor.apply()
                val intent = Intent(this@MainActivity, GetStartedActivity::class.java)
                launcher.launch(intent)
                finish()

            }

        }

    }

}