@file:Suppress("EXPERIMENTAL_API_USAGE")

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.take
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

runBlocking {
  val channel = Channel<String>()
  repeat(3) { n ->
    launch {
      while (true) {
        //println("before sending: Message from actor $n")
        channel.send("Message from actor $n")
        println("after sending: Message from actor $n")
      }
    }
  }

  channel.take(10).consumeEach { println(it) }
  channel.close()
}
