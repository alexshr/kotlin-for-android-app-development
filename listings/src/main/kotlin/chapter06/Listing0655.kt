@file:Suppress("EXPERIMENTAL_API_USAGE")

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.delay

sealed class Transaction
data class Deposit(val amount: Int) : Transaction()
data class Withdrawal(val amount: Int) : Transaction()

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun newAccount(startBalance: Int) = GlobalScope.actor<Transaction>(capacity = 10) {
    log("started")
    var balance = startBalance
    for (tx in channel) when (tx) {
        is Deposit -> {
            balance += tx.amount; println("New balance: $balance")
        }
        is Withdrawal -> {
            balance -= tx.amount; println("New balance: $balance")
        }
    }
}

fun main() = runBlocking {
    val bankAccount = newAccount(1000)
    bankAccount.send(Deposit(500))
    bankAccount.send(Withdrawal(1700))
    bankAccount.send(Deposit(4400))

}
