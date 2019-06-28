import kotlinx.coroutines.delay
import java.util.*

suspend fun task(n: Int, timeMillis: Long): Long {
    log("Task$n - Start")
    delay(timeMillis)
    log("Task$n - After delay $timeMillis ms")

    return timeMillis
}

fun log(msg: String) = println("[${Date()}] $msg")
