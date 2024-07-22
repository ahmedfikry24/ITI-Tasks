package org.example.shapes

class Rectangle(private val width: Double, private val height: Double) : Shape {

    override fun calcArea(): Double {
        return width * height
    }
}