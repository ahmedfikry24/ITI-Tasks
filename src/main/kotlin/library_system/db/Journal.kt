package org.example.library_system.db

class Journal : LibraryItem() {
    override fun isAvailable(): Boolean {
        return libraryDB.journals.any { it.name == name }
    }
}