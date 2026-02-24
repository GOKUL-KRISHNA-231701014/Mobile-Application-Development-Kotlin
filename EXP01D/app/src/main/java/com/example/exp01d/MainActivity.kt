package com.example.exp01d

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtTemp = findViewById<EditText>(R.id.edtTemp)
        val btnCelsius = findViewById<Button>(R.id.btnCelsius)
        val btnFahrenheit = findViewById<Button>(R.id.btnFahrenheit)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        // Celsius → Fahrenheit
        btnCelsius.setOnClickListener {
            if (edtTemp.text.isEmpty()) {
                txtResult.text = "Please enter the temperature"
            } else {
                val celsius = edtTemp.text.toString().toDouble()
                val fahrenheit = (celsius * 9 / 5) + 32
                txtResult.text = "%.2f".format(fahrenheit)
            }
        }

        // Fahrenheit → Celsius
        btnFahrenheit.setOnClickListener {
            if (edtTemp.text.isEmpty()) {
                txtResult.text = "Please enter the temperature"
            } else {
                val fahrenheit = edtTemp.text.toString().toDouble()
                val celsius = (fahrenheit - 32) * 5 / 9
                txtResult.text = "%.2f".format(celsius)
            }
        }

        // Clear
        btnClear.setOnClickListener {
            edtTemp.text.clear()
            txtResult.text = ""
        }
    }
}
