import kotlinx.coroutines.*

fun main() {
    log("Start - Parallel")

    val taskComplete = mutableListOf<Int>()

    runBlocking {
        log("Begin of runBlocking")

        launch {
            taskComplete.add(task(1, 3000))
            log("taskComplete 1 = $taskComplete")
        }

        log("---------------------")

        launch {
            taskComplete.add(task(2, 2000))
            log("taskComplete 2 = $taskComplete")
        }

        log("---------------------")

        launch {
            taskComplete.add(task(3, 5000))
            log("taskComplete 3 = $taskComplete")
        }

        log("---------------------")

        launch {
            taskComplete.add(task(4, 1000))
            log("taskComplete 4 = $taskComplete")
        }

        log("End of runBlocking")
    }

    log("taskComplete = $taskComplete")

    log("End")
}

/* Output
[Fri Jun 28 10:28:02 ICT 2019] Start - Parallel
[Fri Jun 28 10:28:02 ICT 2019] Begin of runBlocking
[Fri Jun 28 10:28:02 ICT 2019] ---------------------
[Fri Jun 28 10:28:02 ICT 2019] ---------------------
[Fri Jun 28 10:28:02 ICT 2019] ---------------------
[Fri Jun 28 10:28:02 ICT 2019] End of runBlocking
[Fri Jun 28 10:28:02 ICT 2019] Task1 - Start
[Fri Jun 28 10:28:02 ICT 2019] Task2 - Start
[Fri Jun 28 10:28:02 ICT 2019] Task3 - Start
[Fri Jun 28 10:28:02 ICT 2019] Task4 - Start
[Fri Jun 28 10:28:03 ICT 2019] Task4 - After delay 1000 ms
[Fri Jun 28 10:28:03 ICT 2019] taskComplete 4 = [4]
[Fri Jun 28 10:28:04 ICT 2019] Task2 - After delay 2000 ms
[Fri Jun 28 10:28:04 ICT 2019] taskComplete 2 = [4, 2]
[Fri Jun 28 10:28:05 ICT 2019] Task1 - After delay 3000 ms
[Fri Jun 28 10:28:05 ICT 2019] taskComplete 1 = [4, 2, 1]
[Fri Jun 28 10:28:07 ICT 2019] Task3 - After delay 5000 ms
[Fri Jun 28 10:28:07 ICT 2019] taskComplete 3 = [4, 2, 1, 3]
[Fri Jun 28 10:28:07 ICT 2019] taskComplete = [4, 2, 1, 3]
[Fri Jun 28 10:28:07 ICT 2019] End
*/
