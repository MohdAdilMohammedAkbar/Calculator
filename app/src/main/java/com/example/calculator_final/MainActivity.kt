package com.example.calculator_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var number1EditText: EditText
    private lateinit var number2EditText: EditText
    private lateinit var addButton: Button
    private lateinit var subtractButton: Button
    private lateinit var multiplyButton: Button
    private lateinit var divideButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1EditText = findViewById(R.id.number1EditText)
        number2EditText = findViewById(R.id.number2EditText)
        addButton = findViewById(R.id.addButton)
        subtractButton = findViewById(R.id.subtractButton)
        multiplyButton = findViewById(R.id.multiplyButton)
        divideButton = findViewById(R.id.divideButton)
        resultTextView = findViewById(R.id.resultTextView)

        addButton.setOnClickListener {
            performOperation('+')
        }

        subtractButton.setOnClickListener {
            performOperation('-')
        }

        multiplyButton.setOnClickListener {
            performOperation('*')
        }

        divideButton.setOnClickListener {
            performOperation('/')
        }
    }

    private fun performOperation(operator: Char) {
        val num1 = number1EditText.text.toString().toDouble()
        val num2 = number2EditText.text.toString().toDouble()
        val result: Double

        when (operator) {
            '+' -> result = num1 + num2
            '-' -> result = num1 - num2
            '*' -> result = num1 * num2
            '/' -> {
                if (num2 != 0.0) {
                    result = num1 / num2
                } else {
                    resultTextView.text = "Cannot divide by zero"
                    return
                }
            }
            else -> return
        }

        resultTextView.text = "Result: $result"
    }
}
