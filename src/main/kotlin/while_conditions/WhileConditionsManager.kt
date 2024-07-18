package org.example.while_conditions

class WhileConditionsManager {
    fun execute() {
        var num = 1
        while (num <= 20) {
            if (num == 15) break
            if (num % 4 == 0){
                num++
                continue
            }
            println(num)
            num++
        }
    }
}