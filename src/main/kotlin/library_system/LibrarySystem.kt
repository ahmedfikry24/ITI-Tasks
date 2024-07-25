package org.example.library_system

import org.example.library_system.db.*
import org.example.library_system.exceptions.*
import org.example.library_system.users.Librarian
import org.example.library_system.users.User

class LibrarySystem {
    fun begin() {
        println("welcome in library system, identify your type ! librarian/user")
        val identifier = readln()
        println("please enter your name")
        val userName = readln()
        when (identifier) {
            "librarian" -> searchForLibrarians(userName)
            "user" -> searchForUsers(userName)
            else -> throw InvalidType()
        }
        if (identifier == "librarian") {
            println("please enter your password")
            val password = readln()
            val librarian = Librarian()
            librarian.name = userName
            librarian.password = password
            if (loginLibrarian(librarian))
                executeLibrarianOperations()
        } else {
            executeUserOperations(userName)
        }
    }

    // region librarian
    private fun searchForLibrarians(name: String): Boolean {
        return if (libraryDB.librarians[name] != null) true else throw NOLibrarianFound()

    }

    private fun loginLibrarian(librarian: Librarian): Boolean {
        return if (libraryDB.librarians.any {
                it.key == librarian.name && it.value == librarian.password
            }) true else throw InvalidLibrarianLogin()

    }

    private fun executeLibrarianOperations() {
        println("how can i help you? view/add/search/view borrowed/add borrowed/return borrowed")
        val order = readln()
        when (order) {
            "view" -> viewItems()
            "add" -> addItems()
            "search" -> search()
            "add borrowed" -> addBorrowedItems()
            "view borrowed" -> viewBorrowedItems()
            "return borrowed" -> returnBorrowedItems()
            else -> throw InvalidLibrarianOrder()
        }
    }

    private fun viewItems() {
        println("Books:")
        libraryDB.books.forEachIndexed { index, book ->
            println("${index.inc()}- ${book.name}")
        }
        println("Magazines:")
        libraryDB.magazines.forEachIndexed { index, magazine ->
            println("${index.inc()}- ${magazine.name}")
        }
        println("Journals:")
        libraryDB.journals.forEachIndexed { index, journal ->
            println("${index.inc()}- ${journal.name}")
        }
    }

    private fun search() {
        println("enter targeted item name")
        val name = readln()
        val books = libraryDB.books.filter { it.name == name }
        println("books ${books.size} item")
        books.forEachIndexed { index, book ->
            println("${index.inc()}- ${book.name}")
        }
        val magazines = libraryDB.magazines.filter { it.name == name }
        println("magazines ${magazines.size} item")
        magazines.forEachIndexed { index, magazine ->
            println("${index.inc()}- ${magazine.name}")
        }
        val journals = libraryDB.journals.filter { it.name == name }
        println("journals ${journals.size} item")
        journals.forEachIndexed { index, journal ->
            println("${index.inc()}- ${journal.name}")
        }
    }

    private fun addItems() {
        println("enter item type book/magazine/journal")
        val order = readln()
        val libraryItem = when (order) {
            "book" -> Book()
            "magazine" -> Magazine()
            "journal" -> Journal()
            else -> throw InvalidAddItemType()
        }
        println("enter item name")
        val name = readln()
        println("enter item num of pages")
        val numOfPages = readln()
        println("enter item ISBN")
        val isbn = readln()
        libraryItem.name = name
        libraryItem.numberOfPages = numOfPages
        libraryItem.ISBN = isbn
        when (libraryItem) {
            is Book -> libraryDB.books.add(libraryItem)
            is Magazine -> libraryDB.magazines.add(libraryItem)
            is Journal -> libraryDB.journals.add(libraryItem)
        }
        println("done")
    }

    private fun addBorrowedItems() {
        println("enter item type book/magazine/journal")
        val order = readln()
        println("enter item name")
        val name = readln()
        val isAvailable = when (order) {
            "book" -> libraryDB.books.any { it.name == name }
            "magazine" -> libraryDB.magazines.any { it.name == name }
            "journal" -> libraryDB.journals.any { it.name == name }
            else -> throw InvalidAddItemType()
        }
        if (isAvailable) {
            println("enter borrowed name")
            val borrowedName = readln()
            libraryDB.borrowedItems[name] = borrowedName
            when (order) {
                "book" -> libraryDB.books.removeIf { it.name == name }
                "magazine" -> libraryDB.magazines.removeIf { it.name == name }
                "journal" -> libraryDB.journals.removeIf { it.name == name }
            }
            println("done")
        } else throw UnAvailableItem()
    }

    private fun viewBorrowedItems() {
        libraryDB.borrowedItems.forEach {
            println("item name: ${it.key}, borrowed name: ${it.value}")
        }
    }

    private fun returnBorrowedItems() {
        println("enter item type book/magazine/journal")
        val order = readln()
        println("enter item name")
        val name = readln()
        when (order) {
            "book" -> {
                val item = Book()
                item.name = name
                libraryDB.books.add(item)
            }

            "magazine" -> {
                val item = Magazine()
                item.name = name
                libraryDB.magazines.add(item)
            }

            "journal" -> {
                val item = Journal()
                item.name = name
                libraryDB.journals.add(item)
            }

            else -> throw InvalidAddItemType()
        }
        if (libraryDB.borrowedItems.remove(name) == null) throw NoBorrowedItemFound()
    }
// endregion

    // region user
    private fun searchForUsers(name: String): Boolean {
        return if (libraryDB.users.any { it.name == name }) true else throw NOUserFound()
    }

    private fun executeUserOperations(borrowedName: String) {
        println("how can i help you? borrow/lend")
        val order = readln()
        when (order) {
            "borrow" -> borrowItem(borrowedName)
            "lend" -> lendItem(borrowedName)
            else -> throw InvalidUserOrder()
        }
    }

    private fun borrowItem(borrowedName: String) {
        println("enter item type book/magazine/journal")
        val order = readln()
        println("enter item name")
        val name = readln()
        when (order) {
            "book" -> {
                if (libraryDB.books.any { it.name == name }) {
                    libraryDB.borrowedItems[name] = borrowedName
                    libraryDB.books.removeIf { it.name == name }
                }
            }

            "magazine" -> {
                if (libraryDB.magazines.any { it.name == name }) {
                    libraryDB.borrowedItems[name] = borrowedName
                    libraryDB.magazines.removeIf { it.name == name }
                }
            }

            "journal" -> {
                if (libraryDB.journals.any { it.name == name }) {
                    libraryDB.borrowedItems[name] = borrowedName
                    libraryDB.journals.removeIf { it.name == name }
                }
            }

            else -> throw InvalidAddItemType()
        }
        println("done")
    }

    private fun lendItem(borrowedName: String) {
        println("please enter item name")
        val name = readln()
        println("please enter item type book/magazine/journal")
        val type = readln()
        libraryDB.borrowedItems.remove(name)
        when (type) {
            "book" -> {
                val item = Book()
                item.name = name
                libraryDB.books.add(item)
            }

            "magazine" -> {
                val item = Magazine()
                item.name = name
                libraryDB.magazines.add(item)
            }

            "journal" -> {
                val item = Journal()
                item.name = name
                libraryDB.journals.add(item)
            }

            else -> throw InvalidAddItemType()
        }
        println("done")
    }
//endregion

}