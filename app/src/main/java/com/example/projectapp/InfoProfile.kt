package com.example.projectapp
import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class InfoProfile : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profilepage)

        // Fetching data from intent or another source
        val userName = "John Doe"
        val userID = "12345"
        val userEmail = "john.doe@example.com"
        val userPosition = "Manager"

        // Initialize views
        val profileImageView: ImageView = findViewById(R.id.profileImageView)
        val usernameTextView: TextView = findViewById(R.id.usernameTextView)
        val userIdTextView: TextView = findViewById(R.id.userIdTextView)
        val userEmailTextView: TextView = findViewById(R.id.userEmailTextView)
        val userPositionTextView: TextView = findViewById(R.id.userPositionTextView)
        val backButton: Button = findViewById(R.id.btnBack)

        // Set values to views
        setProfileImage(profileImageView, userName)
        usernameTextView.text = "Nama User: $userName"
        userIdTextView.text = "ID User: $userID"
        userEmailTextView.text = "Email: $userEmail"
        userPositionTextView.text = "Jabatan: $userPosition"

        val profileButton: View = findViewById(R.id.btnProfile)
        profileButton.setOnClickListener {
            showProfileContextMenu(profileButton)
        }

        // Handle back button click
        backButton.setOnClickListener {
            // Implement the logic to go back to HomeActivity
            finish()
        }
    }

    // Function to set profile image with user initials
    private fun setProfileImage(imageView: ImageView, userName: String) {
        val initials = userName.split(" ").mapNotNull { it.firstOrNull()?.toString() }.joinToString("")
        // You can set initials as text or use them to generate an image
        // For simplicity, setting initials as text for now
        imageView.setImageResource(android.R.color.darker_gray) // Placeholder color
        imageView.contentDescription = initials // Optional: Set content description for accessibility
    }
    // Function to show logout confirmation dialog
    private fun showLogoutConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Konfirmasi Logout")
        builder.setMessage("Apakah Anda ingin logout?")

        builder.setPositiveButton("Ya") { dialog, which ->
            // Handle ya button click
            performLogout()
        }

        builder.setNegativeButton("Tidak") { dialog, which ->
            // Handle tidak button click
            dialog.dismiss()
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()

        // Set button text color
        val positiveButton = dialog.getButton(DialogInterface.BUTTON_POSITIVE)
        positiveButton.setTextColor(resources.getColor(R.color.Hijau)) // replace with your color

        val negativeButton = dialog.getButton(DialogInterface.BUTTON_NEGATIVE)
        negativeButton.setTextColor(resources.getColor(R.color.Merah)) // replace with your color
    }



    // Function to show the profile context menu
    private fun showProfileContextMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.context_profile, popupMenu.menu)

        // Set a listener for the menu item clicks
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_profile -> {
                    // Handle Profile click
                    // You can add custom actions or navigate to a profile activity here
                    return@setOnMenuItemClickListener true
                }
                R.id.menu_info_profile -> {
                    // Handle Info Profile click
                    // Add your code here to show information about the profile
                    val intent = Intent(this, InfoProfile::class.java)
                    startActivity(intent)
                    return@setOnMenuItemClickListener true
                }
                R.id.menu_logout -> {
                    // Handle Logout click
                    showLogoutConfirmationDialog()
                    return@setOnMenuItemClickListener true
                }
                // Add more cases for other menu items if needed
                else -> return@setOnMenuItemClickListener false
            }
        }

        // Show the profile context menu
        popupMenu.show()
    }

    private fun performLogout() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // Optional: Close the current activity to prevent going back
    }

    // Function to show the popup menu
    fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.context_menu, popupMenu.menu)

        // Set a listener for the menu item clicks
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_logo -> {
                    return@setOnMenuItemClickListener true
                }
                R.id.menu_info_barang -> {
                    // Handle Info Barang click
                    val intent = Intent(this, InfoActivity::class.java)
                    startActivity(intent)
                    finish()
                    return@setOnMenuItemClickListener true
                }
                R.id.menu_tambah_barang -> {
                    // Handle Tambah Barang click
                    val intent = Intent(this, TambahActivity::class.java)
                    startActivity(intent)
                    finish()
                    return@setOnMenuItemClickListener true
                }
                R.id.menu_edit_barang -> {
                    // Handle Edit Barang click
                    val intent = Intent(this, EditActivity::class.java)
                    startActivity(intent)
                    finish()
                    return@setOnMenuItemClickListener true
                }
                R.id.menu_hapus_barang -> {
                    // Handle Hapus Barang click
                    val intent = Intent(this, HapusActivity::class.java)
                    startActivity(intent)
                    finish()
                    return@setOnMenuItemClickListener true
                }
                R.id.menu_riwayat -> {
                    // Handle Riwayat Barang click
                    val intent = Intent(this, RiwayatActivity::class.java)
                    startActivity(intent)
                    finish()
                    return@setOnMenuItemClickListener true
                }
                // Add more cases for other menu items if needed
                else -> return@setOnMenuItemClickListener false
            }
        }
        // Show the popup menu
        popupMenu.show()
    }
}
