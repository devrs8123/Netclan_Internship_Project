package com.example.netclaninternshipproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.ComponentActivity

class RefineActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.refine_layout)

        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val valueTextView = findViewById<TextView>(R.id.valueTextView) // TextView to display selected value

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val value = progress + 1 // Adjusted value to match the km range
                valueTextView.text = "$value km" // Display the selected value in a TextView
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Not needed for this implementation
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Not needed for this implementation
            }
        })
    }
}