import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {
        println("GlobalScope.launch                         working in thread ${Thread.currentThread().name}")
    }

    GlobalScope.launch(Dispatchers.Default) {
        println("GlobalScope.launch(Dispatchers.Default)    working in thread ${Thread.currentThread().name}")
    }

    GlobalScope.launch(Dispatchers.IO) {
        println("GlobalScope.launch(Dispatchers.IO)         working in thread ${Thread.currentThread().name}")
    }

    // Exception
//    GlobalScope.launch(Dispatchers.Main) {
//        println("GlobalScope.launch(Dispatchers.Main)       working in thread ${Thread.currentThread().name}")
//    }

    GlobalScope.launch(Dispatchers.Unconfined) {
        println("GlobalScope.launch(Dispatchers.Unconfined) working in thread ${Thread.currentThread().name}")
    }
}

/* Output
GlobalScope.launch                         working in thread DefaultDispatcher-worker-1
GlobalScope.launch(Dispatchers.Default)    working in thread DefaultDispatcher-worker-3
GlobalScope.launch(Dispatchers.IO)         working in thread DefaultDispatcher-worker-1
GlobalScope.launch(Dispatchers.Unconfined) working in thread main
*/
