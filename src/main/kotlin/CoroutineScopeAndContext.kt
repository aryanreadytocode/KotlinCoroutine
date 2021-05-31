import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    //this: CoroutineScope instance
    // coroutineContext: CoroutineContext instance

    /* Without Parameter: Confined [CONFINED DISPATCHER]
    *   - Inherits CoroutineContext from immediate parent coroutine
    *   - Even after delay() or suspending function, it continue to run int the same thread.*/
    launch {
        println("C1: ${Thread.currentThread().name}")  //Thread: main
        delay(1000)
        println("C1: ${Thread.currentThread().name}")
    }

    /* With Parameter: Dispatcher.Default [Similar to GlobalScope.launch{} ]
    *   - Gets its own context at Global level. Execute in a separate background thread
    *   - After delay() or suspending function execution,
    *       it continue to run either in the same thread or some other thread. */
    launch(Dispatchers.Default) {
        println("C2: ${Thread.currentThread().name}")  //Thread: main
        delay(1000)
        println("C2: ${Thread.currentThread().name}")
    }

    /* With parameter: Dispatcher.Unconfined  [UNCONFINED DISPATCHER]
    *   - Inherits CoroutineContext from immediate parent coroutine
    *   - After delay() or suspending function execution, it continues to run in some other thread.  */
    launch(Dispatchers.Unconfined) {
        println("C3: ${Thread.currentThread().name}")  //Thread: main
        delay(1000)
        println("C3: ${Thread.currentThread().name}")
    }

    println("main thread ends")
}