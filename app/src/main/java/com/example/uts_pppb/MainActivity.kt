package com.example.uts_pppb

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
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
    private lateinit var sisaKalori: TextView
    private lateinit var txtKonsumsiKalori: TextView

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
        sisaKalori = findViewById(R.id.txt_sisa_kalori)
        txtKonsumsiKalori = findViewById(R.id.txt_konsumsi_kalori)

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
        val kaloriMasuk = intent.getStringExtra("fillJumlah")
        val kaloriKeluar = intent.getBooleanArrayExtra("fillKaloriJumlah")
//        val sisaKalori = kaloriHarian-kaloriMasuk
        val btnInputData = findViewById<Button>(R.id.btn_input_data)
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

                val intent = Intent(this@MainActivity, InputDataActivity::class.java)
                    .apply { putExtra("nama", nama)
                    putExtra("beratBadanSekarang", beratBadanSekarang)
                    putExtra("spinnerBbNow", spinnerBbNow)
                    putExtra("beratBadanTarget", beratBadanTarget)
                    putExtra("tujuanDiet", tujuanDiet)
                    putExtra("tanggalTarget", tanggalTarget)
                    putExtra("kaloriHarian", kaloriHarian)
                    }
                launcher.launch(intent)

            }

        }

    }

}