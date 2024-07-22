package org.example.shapes

class Triangle(private val base: Double, private val height: Double) : Shape() {

    override fun calcArea(): Double {
        return 0.5 * base * height
    }
}