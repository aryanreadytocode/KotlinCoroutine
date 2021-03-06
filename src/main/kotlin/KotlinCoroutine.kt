import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking { // execute in main thread
    println("Main programs starts: ${Thread.currentThread().name} args: $args")

    GlobalScope.launch {
        println("Fake work starts: ${Thread.currentThread().name }")
        myDelay(1000)
        println("Fake work finished: ${Thread.currentThread().name}")
    }
    myDelay(2000)
    // some other codes ....
    println("Main program ends: ${Thread.currentThread().name}")
}

suspend fun myDelay(timeInMs: Long){
    delay(timeInMs)
}