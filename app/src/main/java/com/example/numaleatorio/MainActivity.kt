package com.example.numaleatorio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var editTextMin: EditText
    private lateinit var editTextMax: EditText
    private lateinit var buttonGenerate: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextMin = findViewById(R.id.editTextMin)
        editTextMax = findViewById(R.id.editTextMax)
        buttonGenerate = findViewById(R.id.buttonGenerate)
        textViewResult = findViewById(R.id.textViewResult)

        buttonGenerate.setOnClickListener {
            generarNumeroAleatorio()
        }
    }

    private fun generarNumeroAleatorio() {
        val minStr = editTextMin.text.toString()
        val maxStr = editTextMax.text.toString()

        if (minStr.isEmpty() || maxStr.isEmpty()) {
            textViewResult.text = "-"
            Toast.makeText(this, "Por favor, ingresa ambos números.", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val min = minStr.toInt()
            val max = maxStr.toInt()

            if (min > max) {
                textViewResult.text = "-"
                Toast.makeText(this, "El número mínimo no puede ser mayor que el máximo.", Toast.LENGTH_SHORT).show()
                return
            }

            val numeroAleatorio = Random.nextInt(min, max + 1)
            textViewResult.text = numeroAleatorio.toString()

        } catch (e: NumberFormatException) {
            textViewResult.text = "-"
            Toast.makeText(this, "Por favor, ingresa números válidos.", Toast.LENGTH_SHORT).show()
        }
    }
}