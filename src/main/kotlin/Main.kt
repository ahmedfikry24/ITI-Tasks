package org.example

import org.example.shapes.Circle
import org.example.shapes.Picture
import org.example.shapes.Rectangle
import org.example.shapes.Triangle

fun main() {
    val rectangle = Rectangle(width = 12.toDouble(), height = 6.toDouble())
    val circle = Circle(radius = 5.toDouble())
    val triangle = Triangle(base = 10.toDouble(), height = 16.toDouble())
    val picture = Picture()
    picture.sumAreas(rectangle, circle, triangle)
}

var anyValue: Any = "fdfd"
fun casting() {
    val intValue: Int? = anyValue as? Int
    println(intValue)
}


fun checkingString() {
    var nullableVar: String? = null
    nullableVar?.let { println(it.length) }
        ?: run {
            nullableVar = "ahmed"
            println(nullableVar!!.length)
        }
}

fun printName() {
    val readName = readlnOrNull()
    val nullableVar: String = readName ?: "Guest"
    println(nullableVar)
}
