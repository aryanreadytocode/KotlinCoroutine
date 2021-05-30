fun main(args: Array<String>) { // execute in main thread
    println("Main programs starts: ${Thread.currentThread().name} args: $args")

    // some other codes ....
    println("Main program ends: ${Thread.currentThread().name}")
}