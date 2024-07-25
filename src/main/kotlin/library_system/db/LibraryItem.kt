package org.example.library_system.db

abstract class LibraryItem {
    lateinit var name: String
    lateinit var numberOfPages: String
    lateinit var ISBN: String

    abstract fun isAvailable(): Boolean
}