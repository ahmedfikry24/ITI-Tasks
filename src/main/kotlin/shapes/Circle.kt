package org.example.shapes

import kotlin.math.pow

class Circle(private val radius: Double) : Shape() {

    override fun calcArea(): Double {
        return 2 * radius.pow(2)
    }
}