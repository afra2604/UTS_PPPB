package com.example.uts_pppb

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.example.uts_pppb.databinding.ActivityInputDataBinding

class InputDataActivity : AppCompatActivity() {

    private lateinit var fillMakanan: EditText
    private lateinit var fillJumlah:EditText
    private lateinit var spinJenis: Spinner
    private lateinit var spinWaktu:Spinner
    private lateinit var fillWO:EditText
    private lateinit var fillDurasi:EditText
    private lateinit var spinWaktuWO: Spinner
    private lateinit var fillKaloriJumlah: EditText
    private lateinit var btnSimpan1: Button


    private lateinit var binding: ActivityInputDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fillMakanan = findViewById(R.id.fill_makanan)
        fillJumlah = findViewById(R.id.fill_jumlah)
        spinJenis = findViewById(R.id.spin_jenis)
        spinWaktu = findViewById(R.id.spin_waktu)
        fillWO = findViewById(R.id.fill_wo)
        fillDurasi = findViewById(R.id.fill_durasi)
        spinWaktuWO = findViewById(R.id.spin_waktu_wo)
        fillKaloriJumlah = findViewById(R.id.fill_kalori_jumlah)
        btnSimpan1 = findViewById(R.id.btn_simpan1)


        val jenisKaloriSpinner = findViewById<Spinner>(R.id.spin_jenis)
        val jenisKaloriList =
            listOf("Karbohidrat", "Lemak", "Mineral", "Protein", "Vitamin", "Zat besi")
        val jenisKaloriAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, jenisKaloriList)
        jenisKaloriAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        jenisKaloriSpinner.adapter = jenisKaloriAdapter

        val waktuMakanSpinner = findViewById<Spinner>(R.id.spin_waktu)
        val waktuMakanList = listOf("Pagi", "Siang", "Malam")
        val waktuMakanAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, waktuMakanList)
        waktuMakanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        waktuMakanSpinner.adapter = waktuMakanAdapter

        val waktuWOSpinner = findViewById<Spinner>(R.id.spin_waktu_wo)
        val waktuWOList = listOf("Pagi", "Siang", "Malam")
        val waktuWOAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, waktuWOList)
        waktuMakanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        waktuWOSpinner.adapter = waktuWOAdapter

        btnSimpan1.setOnClickListener {
            val intent = Intent (this, MainActivity::class.java);
            val namaMakanan = fillMakanan.text.toString()
            val jumlahKalori = fillJumlah.text.toString()
            val jenisKalori = jenisKaloriSpinner.selectedItem.toString()
            val waktuMakan = waktuMakanSpinner.selectedItem.toString()
            val namaWorkout = fillWO.text.toString()
            val durasiWorkout = fillDurasi.text.toString()
            val jumlahKaloriWorkout = fillKaloriJumlah.text.toString()
            val waktuWorkout = waktuWOSpinner.selectedItem.toString()


            val sharedPreferences = getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            var sisaKalori = sharedPreferences.getString("kaloriHarian","0")?.toInt()
            sisaKalori = (sisaKalori?.plus(jumlahKalori.toInt() - jumlahKaloriWorkout.toInt()) ?:0)
            editor.putString("nama_makanan", namaMakanan)
            editor.putString("kaloriMasuk", jumlahKalori)
            editor.putString("jenis_kalori", jenisKalori)
            editor.putString("waktu_makan", waktuMakan)
            editor.putString("nama_workout", namaWorkout)
            editor.putString("durasi_workout", durasiWorkout)
            editor.putString("kaloriKeluar", jumlahKaloriWorkout)
            editor.putString("waktu_workout", waktuWorkout)
            editor.putString("kaloriHarian", sisaKalori.toString())
            editor.apply()


            startActivity(intent)
            finish()
        }



    }
    }