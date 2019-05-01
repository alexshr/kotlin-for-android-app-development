//val name: String? = "Peter"
val name: String? = null

fun greet(name: String) = println("Hi $name!")

greet(name ?: "Anonymous")  // Safe alternative using elvis operator
greet(name!!)               // Better be sure that ‘name’ cannot be null here

