package com.example.kris_21

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var isBigFont = false
    private var isBlueText = false
    private var isBlueBg = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtCollege = findViewById<TextView>(R.id.txtCollege)
        val btnFontSize = findViewById<Button>(R.id.btnFontSize)
        val btnFontColor = findViewById<Button>(R.id.btnFontColor)
        val btnBgColor = findViewById<Button>(R.id.btnBgColor)
        val mainLayout = findViewById<LinearLayout>(R.id.mainLayout)

        // Change Font Size
        btnFontSize.setOnClickListener {
            if (isBigFont) {
                txtCollege.textSize = 20f
                Toast.makeText(this, "Font size reset", Toast.LENGTH_SHORT).show()
            } else {
                txtCollege.textSize = 28f
                Toast.makeText(this, "Font size increased", Toast.LENGTH_SHORT).show()
            }
            isBigFont = !isBigFont
        }

        // Change Font Color
        btnFontColor.setOnClickListener {
            if (isBlueText) {
                txtCollege.setTextColor(Color.BLACK)
                Toast.makeText(this, "Font color reset", Toast.LENGTH_SHORT).show()
            } else {
                txtCollege.setTextColor(Color.BLUE)
                Toast.makeText(this, "Font color changed", Toast.LENGTH_SHORT).show()
            }
            isBlueText = !isBlueText
        }

        // Change Background Color
        btnBgColor.setOnClickListener {
            if (isBlueBg) {
                mainLayout.setBackgroundColor(Color.WHITE)
                Toast.makeText(this, "Background reset", Toast.LENGTH_SHORT).show()
            } else {
                mainLayout.setBackgroundColor(Color.GREEN)
                Toast.makeText(this, "Background color changed", Toast.LENGTH_SHORT).show()
            }
            isBlueBg = !isBlueBg
        }
    }
}
