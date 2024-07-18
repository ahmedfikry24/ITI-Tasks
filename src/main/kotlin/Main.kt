package org.example

import org.example.pyramid_pattern.PyramidPatternManager

fun main() {
    val pyramidManager = PyramidPatternManager()
    runCatching {
        pyramidManager.drawPyramid()
    }.onSuccess {
        println("are you want to draw another pyramid? yes/no")
        val answer = readln()
        if (answer == "yes")
            pyramidManager.drawPyramid()
    }.onFailure {
        println("we can not understand this symbol, are you want execute again? yes/no")
        val answer = readln()
        if (answer == "yes")
            pyramidManager.drawPyramid()
    }
}