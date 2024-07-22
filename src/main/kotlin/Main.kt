package org.example

fun main() {
    printName()
}

fun greeting(message: String = "greeting ahmed ") {
    println(message)
}

var anyValue: Any = 10
fun casting() {
    val intValue: Int = anyValue as Int
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
