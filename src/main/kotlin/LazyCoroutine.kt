import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")
        val msgOne: Deferred<String> = async(start = CoroutineStart.LAZY) { getMessageOne1() }
        val msgTwo: Deferred<String> = async(start = CoroutineStart.LAZY) { getMessageTwo2() }
        println("The entire message is : ${msgOne.await().plus(msgTwo.await())}")
    println("Main program ends: ${Thread.currentThread().name}")
}

suspend fun getMessageOne1(): String {
    delay(1000)
    println("After working in getMessageOne1")
    return "hello"
}

suspend fun getMessageTwo2(): String {
    delay(1000)
    println("After working in getMessageTwo2")
    return "world"
}
