package org.example.shapes

class Picture() {
    fun sumAreas(vararg shape: Shape): Double {
        val result = shape.sumOf { it.calcArea() }
        println("areas sum: $result")
        return result
    }
}