import kotlinx.coroutines.*
import java.util.*

suspend fun main() {
    log("Start")

    coroutine1(2000)

    log("---------------------")

    coroutine2(2000)

    log("---------------------")

    coroutine3(2000)

    log("End")
}

fun coroutine1(timeMillis: Long) {
    log("coroutine1 - Start")
    GlobalScope.launch {
        delay(timeMillis)
        log("coroutine1 - After delay $timeMillis ms")
    }
    log("coroutine1 - End")
}

fun coroutine2(timeMillis: Long) {
    log("coroutine2 - Start")
    runBlocking {
        launch {
            delay(timeMillis)
            log("coroutine2 - After delay $timeMillis ms")
        }
        log("coroutine2 - End of runBlocking")
    }
    log("coroutine2 - End")
}

suspend fun coroutine3(timeMillis: Long) {
    log("coroutine3 - Start")
    coroutineScope {
        launch {
            delay(timeMillis)
            log("coroutine3 - After delay $timeMillis ms")
        }
        log("coroutine3 - End of coroutineScope")
    }
    log("coroutine3 - End")
}

fun log(msg: String) = println("[${Date()}] $msg")

/* Output
[Thu Jun 27 15:34:51 ICT 2019] Start
[Thu Jun 27 15:34:51 ICT 2019] coroutine1 - Start
[Thu Jun 27 15:34:51 ICT 2019] coroutine1 - End
[Thu Jun 27 15:34:51 ICT 2019] ---------------------
[Thu Jun 27 15:34:51 ICT 2019] coroutine2 - Start
[Thu Jun 27 15:34:51 ICT 2019] coroutine2 - End of runBlocking
[Thu Jun 27 15:34:53 ICT 2019] coroutine1 - After delay 2000 ms
[Thu Jun 27 15:34:53 ICT 2019] coroutine2 - After delay 2000 ms
[Thu Jun 27 15:34:53 ICT 2019] coroutine2 - End
[Thu Jun 27 15:34:53 ICT 2019] ---------------------
[Thu Jun 27 15:34:53 ICT 2019] coroutine3 - Start
[Thu Jun 27 15:34:53 ICT 2019] coroutine3 - End of coroutineScope
[Thu Jun 27 15:34:55 ICT 2019] coroutine3 - After delay 2000 ms
[Thu Jun 27 15:34:55 ICT 2019] coroutine3 - End
[Thu Jun 27 15:34:55 ICT 2019] End
*/
