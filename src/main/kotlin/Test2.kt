import kotlinx.coroutines.*

fun main() {
    log("Start - Sequence")

    var sum = 0L

    runBlocking {
        log("Begin of runBlocking 1")

        launch {
            sum += task(1, 3000)
            log("Sum 1 = $sum")
        }

        log("End of runBlocking 1")
    }

    log("---------------------")

    runBlocking {
        log("Begin of runBlocking 2")

        launch {
            sum += task(2, 2000)
            log("Sum 2 = $sum")
        }

        log("End of runBlocking 2")
    }

    log("---------------------")

    runBlocking {
        log("Begin of runBlocking 3")

        launch {
            sum += task(3, 5000)
            log("Sum 3 = $sum")
        }

        log("End of runBlocking 3")
    }

    log("---------------------")

    runBlocking {
        log("Begin of runBlocking 4")

        launch {
            sum += task(4, 1000)
            log("Sum 4 = $sum")
        }

        log("End of runBlocking 4")
    }

    log("Sum = $sum")

    log("End")
}

/* Output
[Fri Jun 28 10:12:35 ICT 2019] Start - Sequence
[Fri Jun 28 10:12:35 ICT 2019] Begin of runBlocking 1
[Fri Jun 28 10:12:35 ICT 2019] End of runBlocking 1
[Fri Jun 28 10:12:35 ICT 2019] Task1 - Start
[Fri Jun 28 10:12:38 ICT 2019] Task1 - After delay 3000 ms
[Fri Jun 28 10:12:38 ICT 2019] Sum 1 = 3000
[Fri Jun 28 10:12:38 ICT 2019] ---------------------
[Fri Jun 28 10:12:38 ICT 2019] Begin of runBlocking 2
[Fri Jun 28 10:12:38 ICT 2019] End of runBlocking 2
[Fri Jun 28 10:12:38 ICT 2019] Task2 - Start
[Fri Jun 28 10:12:40 ICT 2019] Task2 - After delay 2000 ms
[Fri Jun 28 10:12:40 ICT 2019] Sum 2 = 5000
[Fri Jun 28 10:12:40 ICT 2019] ---------------------
[Fri Jun 28 10:12:40 ICT 2019] Begin of runBlocking 3
[Fri Jun 28 10:12:40 ICT 2019] End of runBlocking 3
[Fri Jun 28 10:12:40 ICT 2019] Task3 - Start
[Fri Jun 28 10:12:45 ICT 2019] Task3 - After delay 5000 ms
[Fri Jun 28 10:12:45 ICT 2019] Sum 3 = 10000
[Fri Jun 28 10:12:45 ICT 2019] ---------------------
[Fri Jun 28 10:12:45 ICT 2019] Begin of runBlocking 4
[Fri Jun 28 10:12:45 ICT 2019] End of runBlocking 4
[Fri Jun 28 10:12:45 ICT 2019] Task4 - Start
[Fri Jun 28 10:12:46 ICT 2019] Task4 - After delay 1000 ms
[Fri Jun 28 10:12:46 ICT 2019] Sum 4 = 11000
[Fri Jun 28 10:12:46 ICT 2019] Sum = 11000
[Fri Jun 28 10:12:46 ICT 2019] End
*/
