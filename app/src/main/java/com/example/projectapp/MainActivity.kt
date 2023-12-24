package com.example.projectapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val SPLASH_TIMEOUT: Long = 1000 // Waktu tampilan splash screen dalam milidetik (2 detik)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Membuat handler untuk menangani tampilan splash dan pindah ke LoginActivity setelah waktu tertentu
        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Menutup activity ini agar tidak bisa kembali ke halaman ini
        }, SPLASH_TIMEOUT)
    }
}
