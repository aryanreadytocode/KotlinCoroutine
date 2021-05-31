import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")

    val time = measureTimeMillis {
        val msgOne: Deferred<String> = async {
            getMessageOne()
        }
        val msgTwo: Deferred<String> = async {
            getMessageTwo()
        }
        println("The entire message is : ${msgOne.await().plus(msgTwo.await())}")
    }
    println("Completed in $time ms")
    println("Main program ends: ${Thread.currentThread().name}")
}

suspend fun getMessageOne(): String {
    delay(1000)
    return "hello"
}

suspend fun getMessageTwo(): String {
    delay(1000)
    return "world"
}
