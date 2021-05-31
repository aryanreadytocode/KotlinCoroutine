import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")

    val job: Job = launch {
        for (i in 0..500){
            print("$i.")
//            delay(50)
            yield()
        }
    }
    delay(200)
    /*job.cancel()
    job.join()*/
    job.cancelAndJoin()

    println("\nMain program ends: ${Thread.currentThread().name}") //main thread
}