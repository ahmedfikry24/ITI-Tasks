package org.example.library_system

class LibrarySystem {
    private val books = mutableListOf("book 1", "book 2", "book 3")
    private val magazines = mutableListOf("magazine 1", "magazine 2", "magazine 3")
    private val journals = mutableListOf("journal 1", "journal 2", "journal 3")
    private val borrowed = mapOf(
        "book 4" to "ahmed",
        "magazine 4" to "mohamed",
        "journal 4" to "fikry",
    )

    fun executeOrder() {
        println("welcome in library system, what can i help you?")
        val order = readln()
        when (order) {
            "view" -> viewItems()
            "search" -> search()
            "add" -> addItem()
            "borrowed" -> trackBorrowed()
            else -> throw Exception()
        }
    }

    private fun viewItems() {
        println("Books:")
        books.forEachIndexed { index, book ->
            println("${index.inc()}- $book")
        }
        println("Magazines:")
        magazines.forEachIndexed { index, magazine ->
            println("${index.inc()}- $magazine")
        }
        println("Journals:")
        journals.forEachIndexed { index, journal ->
            println("${index.inc()}- $journal")
        }
    }

    private fun search() {
        println("enter targeted book name")
        val name = readln()
        val books = books.filter { it == name }
        println("books ${books.size} item")
        books.forEachIndexed { index, book ->
            println("${index.inc()}- $book")
        }
        val magazines = magazines.filter { it == name }
        println("magazines ${magazines.size} item")
        magazines.forEachIndexed { index, magazine ->
            println("${index.inc()}- $magazine")
        }
        val journals = journals.filter { it == name }
        println("journals ${journals.size} item")
        journals.forEachIndexed { index, journal ->
            println("${index.inc()}- $journal")
        }
    }

    private fun addItem() {
        println("enter what type of items you need to add")
        val question = readln()
        when (question) {
            "book" -> addBook()
            "magazine" -> addMagazine()
            "journal" -> addJournal()
        }

    }

    private fun addBook() {
        println("enter book name")
        val name = readln()
        books.add(name)
        println("done")
    }

    private fun addMagazine() {
        println("enter magazine name")
        val name = readln()
        magazines.add(name)
        println("done")
    }

    private fun addJournal() {
        println("enter journal name")
        val name = readln()
        journals.add(name)
        println("done")
    }

   private fun trackBorrowed() {
        borrowed.forEach { (item, borrowen) ->
            println("item: $item , borrowen name: $borrowen")
        }
    }
}