package com.example.exp01c

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow

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

        val edtWeight = findViewById<EditText>(R.id.edtWeight)
        val edtHeight = findViewById<EditText>(R.id.edtHeight)
        val radioMeters = findViewById<RadioButton>(R.id.radioMeters)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        btnCalculate.setOnClickListener {

            if (edtWeight.text.isEmpty() || edtHeight.text.isEmpty()) {
                Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val weight = edtWeight.text.toString().toDouble()
            var height = edtHeight.text.toString().toDouble()

            // Convert cm to meters if selected
            if (!radioMeters.isChecked) {
                height /= 100
            }

            val bmi = weight / height.pow(2)
            txtResult.text = "Your BMI: %.2f".format(bmi)
        }
    }
}
