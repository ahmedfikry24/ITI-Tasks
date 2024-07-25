package org.example.library_system.users

class Librarian : Person() {
    lateinit var password: String

    init {
        id++
    }

    companion object {
        var id: Int = 0
    }
}