import kotlinx.coroutines.delay
import java.util.*

suspend fun task(n: Int, timeMillis: Long): Int {
    log("Task$n - Start")
    delay(timeMillis)
    log("Task$n - After delay $timeMillis ms")

    return n
}

fun log(msg: String) = println("[${Date()}] $msg")
