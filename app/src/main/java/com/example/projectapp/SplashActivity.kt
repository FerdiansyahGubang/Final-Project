package com.example.projectapp
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.projectapp.MainActivity
import com.example.projectapp.R

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIMEOUT: Long = 2000 // Waktu tampilan splash screen dalam milidetik (2 detik)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)

        // Membuat handler untuk menangani tampilan splash dan pindah ke MainActivity setelah waktu tertentu
        Handler().postDelayed({
            val mainIntent = Intent(this@SplashActivity, LoginActivity::class.java)
            startActivity(mainIntent)
            finish() // Menutup splash screen agar tidak bisa kembali ke halaman ini
        }, SPLASH_TIMEOUT)
    }
}
