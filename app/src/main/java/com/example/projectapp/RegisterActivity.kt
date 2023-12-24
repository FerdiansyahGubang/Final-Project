package com.example.projectapp
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var registerButton: Button
    private lateinit var loginTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registerpage)

        // Inisialisasi komponen UI
        emailEditText = findViewById(R.id.emailDaftar)
        usernameEditText = findViewById(R.id.usernameDaftar)
        passwordEditText = findViewById(R.id.passwordDaftar)
        registerButton = findViewById(R.id.registerButton)
        loginTextView = findViewById(R.id.loginTextView)

        // Menambahkan OnClickListener ke tombol register
        registerButton.setOnClickListener {
            performRegistration()
        }

        // Menambahkan OnClickListener ke teks untuk pindah ke halaman login
        loginTextView.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun performRegistration() {
        // Implementasi logika registrasi di sini
        val email = emailEditText.text.toString()
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()

        // Contoh sederhana, Anda perlu menggantinya dengan logika registrasi yang sesuai dengan kebutuhan aplikasi Anda
        // Misalnya, mengirim data ke server atau menyimpan data ke database lokal
        // Anda bisa menambahkan logika sesuai dengan kebutuhan aplikasi Anda
    }
}
