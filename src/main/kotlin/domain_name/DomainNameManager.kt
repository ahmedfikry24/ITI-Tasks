package org.example.domain_name

class DomainNameManager {
    lateinit var firstName: String
    lateinit var lastName: String

    fun getFullName() {
        println("enter your first name")
        firstName = readLine() ?: ""
        println("enter your second name")
        lastName = readLine() ?: ""
        if (firstName.isBlank() || lastName.isBlank())
            throw RuntimeException()
        println("your full name: $firstName $lastName")
    }
}