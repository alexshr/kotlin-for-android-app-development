import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext
import kotlinx.coroutines.Dispatchers.Unconfined

runBlocking {

    val jobs = mutableListOf<Job>()

    // DefaultDispatcher (CommonPool at the time of writing)
    jobs += launch {
        println("Default: In thread ${Thread.currentThread().name} before delay")
        delay(500)
        println("Default: In thread ${Thread.currentThread().name} after delay")
    }

    @Suppress("EXPERIMENTAL_API_USAGE")
    jobs += launch(newSingleThreadContext("New Thread")) {
        println("New Thread: In thread ${Thread.currentThread().name} before delay")
        delay(500)
        println("New Thread: In thread ${Thread.currentThread().name} after delay")
    }

    jobs += launch(Unconfined) {
        println("Unconfined: In thread ${Thread.currentThread().name} before delay")
        delay(500)
        println("Unconfined: In thread ${Thread.currentThread().name} after delay")
    }

    jobs += launch(coroutineContext) {
        println("cC: In thread ${Thread.currentThread().name} before delay")
        delay(500)
        println("cC: In thread ${Thread.currentThread().name} after delay")
    }

    jobs.forEach { it.join() }
}
