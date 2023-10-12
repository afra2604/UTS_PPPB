package com.example.uts_pppb

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import com.example.uts_pppb.databinding.ActivityGetStartedBinding


class GetStartedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGetStartedBinding
    private lateinit var namaEditText: EditText
    private lateinit var beratBadanSekarangEditText: EditText
    private lateinit var beratBadanTargetEditText: EditText
    private lateinit var tujuanDietSpinner: Spinner
    private lateinit var kaloriHarianEditText: EditText
    private lateinit var tanggalTargetDatePicker: DatePicker
    private lateinit var spinnerBbNow: Spinner
    private lateinit var spinnerBbTarget: Spinner
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE)
        spinnerBbNow = findViewById(R.id.spinner_bb_now)
        spinnerBbTarget = findViewById(R.id.spinner_bb_target)
        namaEditText = findViewById(R.id.fill_nama)
        beratBadanSekarangEditText = findViewById(R.id.fill_bb_now)
        beratBadanTargetEditText = findViewById(R.id.fill_bb_target)
        tujuanDietSpinner = findViewById(R.id.tujuan_diet)
        kaloriHarianEditText = findViewById(R.id.kalori_harian)
        tanggalTargetDatePicker = findViewById(R.id.tanggal_target)

        val tujuanDietOptions = arrayOf("Cutting", "Bulking", "Maintaining")
        val bbNowOptions = arrayOf("kg", "pound", "gram", "ons")
        val bbTargetOptions = arrayOf("kg", "pound", "gram", "ons")
        val masuk1 = findViewById<Button>(R.id.masuk_1)

        // Buat adapter untuk Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tujuanDietOptions)
        val adapterBbNow = ArrayAdapter(this, android.R.layout.simple_spinner_item, bbNowOptions)
        val adapterBbTarget = ArrayAdapter(this, android.R.layout.simple_spinner_item, bbTargetOptions)

// Atur tampilan adapter
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterBbNow.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterBbTarget.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Terapkan adapter ke Spinner
        tujuanDietSpinner.adapter = adapter
        spinnerBbNow.adapter = adapterBbNow
        spinnerBbTarget.adapter =adapterBbTarget

        if(sharedPreferences.contains("nama")){
            val intent = Intent(this,  MainActivity::class.java)
            startActivity(intent);
            finish();
        }

        masuk1.setOnClickListener(View.OnClickListener {

            // Mengambil data dari UI
            val nama = namaEditText.text.toString()
            val beratBadanSekarang = beratBadanSekarangEditText.text.toString()
            val beratBadanTarget = beratBadanTargetEditText.text.toString()
            val tujuanDiet = tujuanDietSpinner.selectedItem.toString()
            val kaloriHarian = kaloriHarianEditText.text.toString()
            val day = tanggalTargetDatePicker.dayOfMonth
            val month = tanggalTargetDatePicker.month + 1 // Ingat bulan dimulai dari 0
            val year = tanggalTargetDatePicker.year
            val tanggalTarget = "$year-$month-$day"
            val spinnerBbNow = spinnerBbNow.selectedItem.toString()
            val spinnerBbTarget = spinnerBbTarget.selectedItem.toString()


            val editor = sharedPreferences.edit()
            editor.putString("nama", nama)
            editor.putString("beratBadanSekarang", beratBadanSekarang)
            editor.putString("beratBadanTarget", beratBadanTarget)
            editor.putString("tujuanDiet", tujuanDiet)
            editor.putString("kaloriHarian", kaloriHarian)
            editor.putString("tanggalTarget", tanggalTarget)
            editor.putString("spinnerBbNow", spinnerBbNow)
            editor.putString("spinnerBbTarget", spinnerBbTarget)
            editor.apply()

            val intent = Intent(this,  MainActivity::class.java)
            startActivity(intent)
        })
    }

}