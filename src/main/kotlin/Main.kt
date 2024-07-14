package org.example

import org.example.domain_name.DomainNameManager

fun main() {
    val domainName = DomainNameManager()
    try {
        domainName.getFullName()
    } catch (e: RuntimeException) {
        println("any part of your name must not be nothing, Are you need to try again? yes/no")
        val answer = readln()
        if (answer == "yes")
            domainName.getFullName()
    }
}