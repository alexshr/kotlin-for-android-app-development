import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
  runBlocking {
    // Can call suspending functions inside runBlocking
    updateWeather()
  }
}
