package com.example.projectapp

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class HomeActivity : AppCompatActivity() {

    private lateinit var buttonExit : Button

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)


        // Menambahkan onClickListener ke setiap CardView
        buttonExit = findViewById(R.id.exitButton)
        val infoBarangCard: View = findViewById(R.id.info_barang)
        val tambahBarangCard: View = findViewById(R.id.tambah_barang)
        val editBarangCard: View = findViewById(R.id.edit_barang)
        val hapusBarangCard: View = findViewById(R.id.hapus_barang)
        val riwayatBarangCard: View = findViewById(R.id.riwayat_barang)

        infoBarangCard.setOnClickListener {
            // Pindah ke aktivitas InfoBarangActivity
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
            finish()
        }

        tambahBarangCard.setOnClickListener {
            // Pindah ke aktivitas TambahBarangActivity
            val intent = Intent(this, TambahActivity::class.java)
            startActivity(intent)
            finish()
        }

        editBarangCard.setOnClickListener {
            // Pindah ke aktivitas EditBarangActivity
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
            finish()
        }

        hapusBarangCard.setOnClickListener {
            // Pindah ke aktivitas HapusBarangActivity
            val intent = Intent(this, HapusActivity::class.java)
            startActivity(intent)
            finish()
        }

        riwayatBarangCard.setOnClickListener {
            // Pindah ke aktivitas RiwayatBarangActivity
            val intent = Intent(this, RiwayatActivity::class.java)
            startActivity(intent)
            finish()
        }

        val profileButton: View = findViewById(R.id.btnProfile)
            profileButton.setOnClickListener {
            showProfileContextMenu(profileButton)
        }

        buttonExit.setOnClickListener{
            System.exit(0)
        }

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
