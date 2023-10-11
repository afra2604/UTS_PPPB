package com.example.uts_pppb

import android.content.Intent
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        masuk1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,  MainActivity::class.java)

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

            // Memasukkan data ke dalam Intent
            intent.putExtra("nama", nama)
            intent.putExtra("beratBadanSekarang", beratBadanSekarang)
            intent.putExtra("beratBadanTarget", beratBadanTarget)
            intent.putExtra("tujuanDiet", tujuanDiet)
            intent.putExtra("kaloriHarian", kaloriHarian)
            intent.putExtra("tanggalTarget", tanggalTarget)
            intent.putExtra("spinnerBbNow", spinnerBbNow)
            intent.putExtra("spinnerBbTarget", spinnerBbTarget)



            startActivity(intent)
        })
    }

}