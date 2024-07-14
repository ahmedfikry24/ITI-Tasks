package org.example.temperature_converter

import kotlin.properties.Delegates

class TemperatureConverterManager {
    private var celsiusTemperature by Delegates.notNull<Float>()
    private var fahrenheitTemperature by Delegates.notNull<Float>()
    fun calculate() {
        println("please enter temperature in celsius")
        celsiusTemperature = readln().toFloat()
        if (celsiusTemperature.isInfinite()) throw RuntimeException()
        fahrenheitTemperature = celsiusTemperature.times(9 / 5).plus(32)
        println("your temperature in fahrenheit: $fahrenheitTemperature")
        println("Are you need to calculate a new value? yes/no")
        val answer = readln()
        if (answer == "yes")
            calculate()
    }
}