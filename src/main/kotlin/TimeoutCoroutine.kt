import kotlinx.coroutines.*
import java.lang.Exception

/*fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")

    withTimeout(2000){
        try {
            for (i in 0..500) {
                println("$i.")
                delay(500)
            }
        } catch (ex: TimeoutCancellationException){
            println("\nException has catch safely..")
        }
    }

    println("\nMain program ends: ${Thread.currentThread().name}")
}*/

fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")

    val result: String? = withTimeoutOrNull(2000){
            for (i in 0..500) {
                println("$i.")
                delay(500)
            }
        "I am done"
    }
    println("result $result")

    println("\nMain program ends: ${Thread.currentThread().name}")
}