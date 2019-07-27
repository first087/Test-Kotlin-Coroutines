import kotlinx.coroutines.*

fun main() {
    runBlocking {
        launch {
            println("launch                         working in thread ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default) {
            println("launch(Dispatchers.Default)    working in thread ${Thread.currentThread().name}")
        }

        launch(Dispatchers.IO) {
            println("launch(Dispatchers.IO)         working in thread ${Thread.currentThread().name}")
        }

        // Exception
//        launch(Dispatchers.Main) {
//            println("launch(Dispatchers.Main)       working in thread ${Thread.currentThread().name}")
//        }

        launch(Dispatchers.Unconfined) {
            println("launch(Dispatchers.Unconfined) working in thread ${Thread.currentThread().name}")
        }
    }
}

/* Output
launch(Dispatchers.Default)    working in thread DefaultDispatcher-worker-1
launch(Dispatchers.IO)         working in thread DefaultDispatcher-worker-1
launch(Dispatchers.Unconfined) working in thread main
launch                         working in thread main
*/
