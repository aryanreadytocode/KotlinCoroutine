import kotlinx.coroutines.*

/*Child coroutine scope inherit form parent
* runBlocking coroutine run on main
* so child launch will also work on main*/
fun main(args: Array<String>) = runBlocking { // creates a blocking coroutine that execute in current thread(main)
    println("Main programs starts: ${Thread.currentThread().name} args: $args")

    val job: Job = launch {
        println("Fake work starts: ${Thread.currentThread().name }")
        delay(1000)
        println("Fake work finished: ${Thread.currentThread().name}")
    }
//    delay(2000)
    job.join()
    // some other codes ....
    println("Main program ends: ${Thread.currentThread().name}")
}

suspend fun myDelay1(timeInMs: Long) {
    delay(timeInMs)
}