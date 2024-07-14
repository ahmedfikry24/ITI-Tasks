package org.example

import org.example.calculator.CalculatorManager

fun main() {
    try {
        val calculator = CalculatorManager()
        calculator.execute()
    } catch (e: RuntimeException) {
        println("we can not calculate this operation yet")
    }
}