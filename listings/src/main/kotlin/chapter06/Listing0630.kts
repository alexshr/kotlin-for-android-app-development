import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Dispatchers.Unconfined
import kotlinx.coroutines.launch


GlobalScope.launch(Unconfined) {
  println("Running on ${Thread.currentThread().name}")
}