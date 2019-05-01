@file:Suppress("EXPERIMENTAL_API_USAGE")

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.actor

import kotlinx.coroutines.runBlocking

val actor = GlobalScope.actor<String> {
    val message = channel.receive()
    println(message)
}

runBlocking {
    actor.send("Hello World!")  // Sends an element to the actor’s channel
    actor.close()    // Closes channel because actor is no longer needed
}
