package org.example.library_system.db

import org.example.library_system.users.User

val libraryDB = LibraryDataBase()

class LibraryDataBase {
    val librarians = mutableMapOf("ahmed" to "1234")
    val users = mutableListOf<User>()
    val borrowedItems = mutableMapOf<String, String>()
    val books = mutableListOf<Book>()
    val magazines = mutableListOf<Magazine>()
    val journals = mutableListOf<Journal>()

    init {
        repeat(5) {
            val book = Book()
            val magazine = Magazine()
            val journal = Journal()
            book.name = "book $it"
            magazine.name = "magazine $it"
            journal.name = "journal $it"
            books.add(book)
            magazines.add(magazine)
            journals.add(journal)
        }
        borrowedItems["mohamed"] = "book 6"
        val user = User()
        user.name = "mohamed"
        users.add(user)
    }
}