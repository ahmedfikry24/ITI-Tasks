package org.example.library_system.db

class Magazine : LibraryItem() {
    override fun isAvailable(): Boolean {
        return libraryDB.magazines.any { it.name == name }
    }
}