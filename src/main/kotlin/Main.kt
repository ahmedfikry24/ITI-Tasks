package org.example

import kotlinx.coroutines.*

fun main() {
//        task1()

//        val result = task2(5)
//        println("factorial is: $result")

//    task3()

//    runBlocking {
//        val result = task4(arrayOf(10,10,15,5,20,30))
//        println("sum is: $result")
//    }

//    task5()
}

fun task1() {
    runBlocking {
        async {
            repeat(10) {
                delay(100)
                println("num: ${it.inc()}")
            }
        }.start()
    }
}

fun task2(num: Int): Int {
    return runBlocking {
        async {
            delay(100)
            if (num == 0 || num == 1) {
                1
            } else {
                num * task2(num - 1)
            }
        }.await()
    }
}

fun task3() {
    runBlocking {
        val scope = CoroutineScope(Dispatchers.Default)
        val job1 = scope.launch {
            repeat(5) {
                println(it)
            }
        }
        val job2 = scope.launch {
            repeat(5) {
                println("ahmed")
            }
        }
        job1.join()
        job2.join()
        delay(10000)
        job1.cancel()
        job2.cancel()
    }
}

suspend fun task4(list: Array<Int>):Int {
    var element = 0
     list.forEach {
         element = it
        element += element
    }
   return element
}

fun task5(){
    runBlocking {
        val scope = CoroutineScope(Dispatchers.Default)
        val job = scope.launch {
            repeat(10){
                delay(1000)
                println("num is: $it")
            }
        }
        job.join()
        delay(2000)
        job.cancelAndJoin()
    }
}