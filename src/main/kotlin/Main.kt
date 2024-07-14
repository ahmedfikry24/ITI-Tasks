package org.example

import org.example.temperature_converter.TemperatureConverterManager

fun main() {
    val temperatureConverter = TemperatureConverterManager()
    try {
        temperatureConverter.calculate()
    } catch (e: Exception) {
        println("we can not assign this value, Are you need to try again? yes/no")
        val answer = readln()
        if (answer == "yes")
            temperatureConverter.calculate()
    }
}