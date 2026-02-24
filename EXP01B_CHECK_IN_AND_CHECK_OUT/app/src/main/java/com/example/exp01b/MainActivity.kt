package com.example.exp01b

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // UI references
        val txtCount = findViewById<TextView>(R.id.txtCount)
        val btnCheckIn = findViewById<Button>(R.id.btnCheckIn)
        val btnCheckOut = findViewById<Button>(R.id.btnCheckOut)

        // Check In button
        btnCheckIn.setOnClickListener {
            count++
            txtCount.text = count.toString()
            Toast.makeText(this, "Checked In", Toast.LENGTH_SHORT).show()
        }

        // Check Out button
        btnCheckOut.setOnClickListener {
            if (count > 0) {
                count--
                txtCount.text = count.toString()
                Toast.makeText(this, "Checked Out", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No one to check out", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
