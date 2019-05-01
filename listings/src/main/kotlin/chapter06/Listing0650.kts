@file:Suppress("EXPERIMENTAL_API_USAGE")

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.runBlocking

// This actor keeps reading from its channel indefinitely
val actor = GlobalScope.actor<String> {
    for (value in channel) println(value)
}

runBlocking {
    actor.send("Hello")  // Makes actor print out Hello
    actor.send("World")  // Makes actor print out World
    actor.close()
}
