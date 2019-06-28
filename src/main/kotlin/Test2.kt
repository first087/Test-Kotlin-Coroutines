import kotlinx.coroutines.*

fun main() {
    log("Start - Sequence")

    val taskComplete = mutableListOf<Int>()

    runBlocking {
        log("Begin of runBlocking 1")

        launch {
            taskComplete.add(task(1, 3000))
            log("taskComplete 1 = $taskComplete")
        }

        log("End of runBlocking 1")
    }

    log("---------------------")

    runBlocking {
        log("Begin of runBlocking 2")

        launch {
            taskComplete.add(task(2, 2000))
            log("taskComplete 2 = $taskComplete")
        }

        log("End of runBlocking 2")
    }

    log("---------------------")

    runBlocking {
        log("Begin of runBlocking 3")

        launch {
            taskComplete.add(task(3, 5000))
            log("taskComplete 3 = $taskComplete")
        }

        log("End of runBlocking 3")
    }

    log("---------------------")

    runBlocking {
        log("Begin of runBlocking 4")

        launch {
            taskComplete.add(task(4, 1000))
            log("taskComplete 4 = $taskComplete")
        }

        log("End of runBlocking 4")
    }

    log("taskComplete = $taskComplete")

    log("End")
}

/* Output
[Fri Jun 28 10:26:51 ICT 2019] Start - Sequence
[Fri Jun 28 10:26:51 ICT 2019] Begin of runBlocking 1
[Fri Jun 28 10:26:51 ICT 2019] End of runBlocking 1
[Fri Jun 28 10:26:51 ICT 2019] Task1 - Start
[Fri Jun 28 10:26:54 ICT 2019] Task1 - After delay 3000 ms
[Fri Jun 28 10:26:54 ICT 2019] taskComplete 1 = [1]
[Fri Jun 28 10:26:54 ICT 2019] ---------------------
[Fri Jun 28 10:26:54 ICT 2019] Begin of runBlocking 2
[Fri Jun 28 10:26:54 ICT 2019] End of runBlocking 2
[Fri Jun 28 10:26:54 ICT 2019] Task2 - Start
[Fri Jun 28 10:26:56 ICT 2019] Task2 - After delay 2000 ms
[Fri Jun 28 10:26:56 ICT 2019] taskComplete 2 = [1, 2]
[Fri Jun 28 10:26:56 ICT 2019] ---------------------
[Fri Jun 28 10:26:56 ICT 2019] Begin of runBlocking 3
[Fri Jun 28 10:26:56 ICT 2019] End of runBlocking 3
[Fri Jun 28 10:26:56 ICT 2019] Task3 - Start
[Fri Jun 28 10:27:01 ICT 2019] Task3 - After delay 5000 ms
[Fri Jun 28 10:27:01 ICT 2019] taskComplete 3 = [1, 2, 3]
[Fri Jun 28 10:27:01 ICT 2019] ---------------------
[Fri Jun 28 10:27:01 ICT 2019] Begin of runBlocking 4
[Fri Jun 28 10:27:01 ICT 2019] End of runBlocking 4
[Fri Jun 28 10:27:01 ICT 2019] Task4 - Start
[Fri Jun 28 10:27:02 ICT 2019] Task4 - After delay 1000 ms
[Fri Jun 28 10:27:02 ICT 2019] taskComplete 4 = [1, 2, 3, 4]
[Fri Jun 28 10:27:02 ICT 2019] taskComplete = [1, 2, 3, 4]
[Fri Jun 28 10:27:02 ICT 2019] End
*/
