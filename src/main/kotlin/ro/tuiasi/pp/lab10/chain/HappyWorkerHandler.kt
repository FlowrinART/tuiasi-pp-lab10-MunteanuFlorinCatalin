// HappyWorkerHandler.kt
package ro.tuiasi.pp.lab10.chain

import kotlinx.coroutines.delay

class HappyWorkerHandler : Handler {

    override var next: Handler? = null
    override var previous: Handler? = null

    override suspend fun handleRequest(message: String): String {
        delay(200)

        println("[HappyWorker] Procesez: $message")

        val raspuns = "Response - $message"

        println("[HappyWorker] Răspund: $raspuns")
        return raspuns
    }
}