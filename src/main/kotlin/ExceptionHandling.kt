import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")

    val job: Job = launch {
        try {
            for (i in 0..500){
                print("$i.")
                delay(5)
            }
        } catch (ex: CancellationException){
            println("\nException caught safely: ${ex.message}")
        } finally {
            withContext(NonCancellable) {
                delay(5)
                println("\nClose resources in finally")
            }
        }

    }
    /*job.cancel()
    job.join()*/
    delay(9)
    job.cancel(CancellationException("aryan exception"))
    job.join()

    println("\nMain program ends: ${Thread.currentThread().name}") //main thread
}