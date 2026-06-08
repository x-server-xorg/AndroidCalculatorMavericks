package com.calcmavericks

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private lateinit var clearButton: Button
    private val calc = CalculatorLogic()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.tvDisplay)
        clearButton = findViewById(R.id.btnClear)
        updateDisplay()

        val numberIds = listOf(
            R.id.btn0 to "0", R.id.btn1 to "1", R.id.btn2 to "2",
            R.id.btn3 to "3", R.id.btn4 to "4", R.id.btn5 to "5",
            R.id.btn6 to "6", R.id.btn7 to "7", R.id.btn8 to "8",
            R.id.btn9 to "9"
        )
        for ((id, digit) in numberIds) {
            findViewById<Button>(id).setOnClickListener { onDigit(digit) }
        }

        findViewById<Button>(R.id.btnDecimal).setOnClickListener { onDecimal() }

        val operatorIds = listOf(
            R.id.btnAdd to "+", R.id.btnSubtract to "−",
            R.id.btnMultiply to "×", R.id.btnDivide to "÷"
        )
        for ((id, op) in operatorIds) {
            findViewById<Button>(id).setOnClickListener { onOperator(op) }
        }

        findViewById<Button>(R.id.btnEquals).setOnClickListener { onEquals() }
        findViewById<Button>(R.id.btnClear).setOnClickListener { onClear() }
        findViewById<Button>(R.id.btnSign).setOnClickListener { onSign() }
        findViewById<Button>(R.id.btnPercent).setOnClickListener { onPercent() }
    }

    private fun onDigit(digit: String) {
        calc.inputDigit(digit)
        updateDisplay()
        updateClearButton()
    }

    private fun onDecimal() {
        calc.inputDecimal()
        updateDisplay()
        updateClearButton()
    }

    private fun onOperator(op: String) {
        calc.inputOperator(op)
        updateDisplay()
        updateClearButton()
    }

    private fun onEquals() {
        calc.evaluate()
        updateDisplay()
        updateClearButton()
    }

    private fun onClear() {
        calc.clear()
        updateDisplay()
        updateClearButton()
    }

    private fun onSign() {
        calc.toggleSign()
        updateDisplay()
    }

    private fun onPercent() {
        calc.percent()
        updateDisplay()
        updateClearButton()
    }

    private fun updateDisplay() {
        display.text = calc.getDisplay()
    }

    private fun updateClearButton() {
        clearButton.text = if (calc.needsAllClear()) "AC" else "C"
    }
}
