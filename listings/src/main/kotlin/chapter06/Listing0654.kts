@file:Suppress("EXPERIMENTAL_API_USAGE")

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.channels.take

fun log(message: String) = println("[${Thread.currentThread().name}] $message")

runBlocking {
  val producer = produce {
    log("start");
    var next = 1

    while (true) {
      send(next)
      next *= 2
    }
  }

  producer.take(10).consumeEach { println(it) }
}
