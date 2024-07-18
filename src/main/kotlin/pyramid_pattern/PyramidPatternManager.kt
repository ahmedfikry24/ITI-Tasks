package org.example.pyramid_pattern

class PyramidPatternManager {
    fun drawPyramid() {
        println("enter number of lines")
        val numOfLines = readln().toInt()
        println("first shape")
        for (i in 1..numOfLines) {
            repeat(i) {
                print("*")
            }
            print("\n")
        }
        println("second shape")
        for (i in 1..numOfLines) {
            repeat(numOfLines - i) {
                print(" ")
            }
            repeat(i) {
                print("* ")
            }
            print("\n")
        }
    }
}