package org.example.library_system.db

class Book : LibraryItem() {
    override fun isAvailable(): Boolean {
        return libraryDB.books.any { it.name == name }
    }
}