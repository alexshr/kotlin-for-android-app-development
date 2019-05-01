import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

GlobalScope.launch { println("Running on ${Thread.currentThread().name}") }
GlobalScope.launch(Dispatchers.Default) { println("Running on ${Thread.currentThread().name}") }
//GlobalScope.launch(CommonPool) { println("Running on ${Thread.currentThread().name}") }
GlobalScope.launch(Dispatchers.Main) { println("Running on ${Thread.currentThread().name}") }