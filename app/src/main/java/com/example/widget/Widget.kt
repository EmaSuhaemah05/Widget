package com.example.widget

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AlertDialog.*
import com.example.widget.databinding.ActivityWidgetBinding
import com.google.android.material.snackbar.Snackbar



//membuat varieable binding
    private lateinit var binding: ActivityWidgetBinding
class Widget : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inisialisasi widget binding
        binding = ActivityWidgetBinding.inflate(layoutInflater)

        //memanggil layout
        setContentView(binding.root)

        binding.btnToast.setOnClickListener {
            Toast.makeText(this, "Ini adalah Toast",Toast.LENGTH_SHORT).show()
        }
        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(it, "Ini adalah Snackbar",Snackbar.LENGTH_SHORT).show()
        }
        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Message")
                setMessage("Ini adalah Alert")

              setPositiveButton("OK"){ dialog,_->
                  Toast.makeText(applicationContext,"Anda Klik Ok",Toast.LENGTH_SHORT).show()
                  dialog.dismiss()
              }
              setNegativeButton("Back"){ dialog,_->
                  Toast.makeText(applicationContext,"Anda Klik Back",Toast.LENGTH_SHORT).show()
                  dialog.dismiss()
              }
            }.show()
        }
    //button custom dialog
    binding.btnCustomDialog.setOnClickListener {
        Dialog(this).apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setCancelable(false)
            setContentView(R.layout.custom_dialog)

            val btnCancel = this.findViewById<Button>(R.id.btnCancel)
            val btnContinue = this.findViewById<Button>(R.id.btnContinue)

            btnCancel.setOnClickListener {
                Toast.makeText(applicationContext,"Anda Klik Cancel",Toast.LENGTH_SHORT).show()
            }
            btnContinue.setOnClickListener {
                Toast.makeText(applicationContext,"Anda Klik Continue",Toast.LENGTH_SHORT).show()
            }

        }.show()
    }

    }
}