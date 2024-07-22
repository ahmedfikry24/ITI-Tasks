package org.example

import org.example.library_system.LibrarySystem

lateinit var librarian: LibrarySystem
fun main() {
    runCatching {
        librarian = LibrarySystem()
        librarian.executeOrder()
    }.onFailure {
        println("we ano not execute this function yet, are you need to start again? yes/no")
        val answer = readln()
        if (answer == "yes")
            librarian.executeOrder()
    }
}