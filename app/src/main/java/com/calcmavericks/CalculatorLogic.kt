package com.calcmavericks

class CalculatorLogic {
    private var current = "0"
    private var previous = ""
    private var operator: String? = null
    private var startNewNumber = true
    private var justEvaluated = false

    fun getDisplay(): String = current

    fun inputDigit(digit: String): String {
        if (justEvaluated) {
            resetAll()
        }
        if (startNewNumber) {
            current = if (digit == "0" && current == "0") "0" else digit
            startNewNumber = false
        } else {
            if (current == "0" && digit != ".") {
                current = digit
            } else {
                current += digit
            }
        }
        return current
    }

    fun inputDecimal(): String {
        if (justEvaluated) {
            resetAll()
        }
        if (startNewNumber) {
            current = "0."
            startNewNumber = false
        } else if (!current.contains(".")) {
            current += "."
        }
        return current
    }

    fun inputOperator(op: String): String {
        if (!startNewNumber && operator != null) {
            evaluate()
        }
        previous = current
        operator = op
        startNewNumber = true
        return current
    }

    fun evaluate(): String {
        if (operator == null) return current
        val prev = previous.toDoubleOrNull() ?: return current
        val curr = current.toDoubleOrNull() ?: return current

        val result = when (operator) {
            "+" -> prev + curr
            "−" -> prev - curr
            "×" -> prev * curr
            "÷" -> if (curr != 0.0) prev / curr else Double.NaN
            else -> curr
        }
        current = formatNumber(result)
        operator = null
        justEvaluated = true
        return current
    }

    fun clear(): String {
        if (current != "0" || startNewNumber.not()) {
            current = "0"
            startNewNumber = true
            return current
        }
        resetAll()
        return current
    }

    fun toggleSign(): String {
        if (current == "0") return current
        current = if (current.startsWith("-")) current.drop(1) else "-$current"
        return current
    }

    fun percent(): String {
        val num = current.toDoubleOrNull() ?: return current
        current = formatNumber(num / 100.0)
        return current
    }

    fun needsAllClear(): Boolean = current == "0" && startNewNumber

    private fun resetAll() {
        current = "0"
        previous = ""
        operator = null
        startNewNumber = true
        justEvaluated = false
    }

    private fun formatNumber(num: Double): String {
        if (num.isNaN() || num.isInfinite()) return "Error"
        return if (num == num.toLong().toDouble()) {
            num.toLong().toString()
        } else {
            num.toString().trimEnd('0').trimEnd('.')
        }
    }
}
