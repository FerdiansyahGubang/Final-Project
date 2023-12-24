package com.example.projectapp

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.PopupWindow
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginpage)

        // Inisialisasi komponen UI
        usernameEditText = findViewById(R.id.usernameLogin)
        passwordEditText = findViewById(R.id.passwordLogin)
        loginButton = findViewById(R.id.loginButton)
        registerTextView = findViewById(R.id.registerLogin)

        // Menambahkan OnClickListener ke tombol login
        loginButton.setOnClickListener {
            performLogin()
        }

        // Menambahkan OnClickListener ke teks untuk pindah ke halaman pendaftaran
        registerTextView.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun performLogin() {
        // Implementasi logika login di sini
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()

        // Contoh sederhana, ganti dengan logika login yang sesuai dengan kebutuhan aplikasi Anda
        if (username == "admin" && password == "admin123") {
            // Jika login berhasil, pindah ke halaman beranda atau halaman utama
            showLoginSuccessPopup()
        } else {
            // Jika login gagal, tampilkan pesan kesalahan menggunakan Toast
            showLoginFailurePopup()
        }
    }

    private fun gotohome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish() // Optional: Close the LoginActivity to prevent navigating back to it using the back button
    }


    private fun showLoginSuccessPopup() {
        val inflater = LayoutInflater.from(this)
        val popupView = inflater.inflate(R.layout.popuplogin, null)

        val popupWindow = PopupWindow(
            popupView,
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            true
        )

        val btnOk = popupView.findViewById<Button>(R.id.okButton)
        btnOk.setOnClickListener {
            // Ketika tombol "OK" pada popup ditekan, pindah ke halaman beranda
            val intent = Intent(this, HomeActivity::class.java) // Gantilah HomeActivity dengan nama Activity beranda Anda
            startActivity(intent)
            popupWindow.dismiss() // Menutup popup setelah pindah ke halaman beranda
            finish() // Menutup aktivitas login agar tidak bisa kembali ke halaman login
        }

        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
    }

    private fun showLoginFailurePopup() {
        val inflater = LayoutInflater.from(this)
        val popupView = inflater.inflate(R.layout.popuplogingagal, null)

        val popupWindow = PopupWindow(
            popupView,
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            true
        )

        val btnClose = popupView.findViewById<Button>(R.id.buttonFail)
        btnClose.setOnClickListener {
            popupWindow.dismiss() // Menutup popup login gagal
        }

        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
    }

}
