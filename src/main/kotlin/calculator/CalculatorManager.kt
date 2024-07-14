package org.example.calculator

import kotlin.properties.Delegates

class CalculatorManager {
    private var firstNum by Delegates.notNull<Long>()
    private lateinit var operator: String
    private var secondNum by Delegates.notNull<Long>()
    private lateinit var isNeedNewCalculation: String
    fun execute() {
        println("enter first number")
        firstNum = readln().toLong()
        println("enter needed operator")
        operator = readln()
        println("enter second number")
        secondNum = readln().toLong()

        val result = when (operator) {
            "+" -> firstNum.plus(secondNum)
            "-" -> firstNum.minus(secondNum)
            "*" -> firstNum.times(secondNum)
            "/" -> firstNum.div(secondNum)
            else -> throw RuntimeException()
        }
        println("your result: $result")
        println("Are you need a new operation ? yes/no")
        isNeedNewCalculation = readln()
        if (isNeedNewCalculation == "yes")
            execute()
    }
}