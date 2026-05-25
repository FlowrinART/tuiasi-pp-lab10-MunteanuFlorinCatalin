// ManagerHandler.kt
package ro.tuiasi.pp.lab10.chain

import kotlinx.coroutines.delay

class ManagerHandler : Handler {

    override var next: Handler? = null
    override var previous: Handler? = null

    override suspend fun handleRequest(message: String): String {
        delay(100)

        println("[Manager] Am primit: $message")

        val raspuns = next?.handleRequest(message) ?: message

        println("[Manager] Răspuns: $raspuns")
        return raspuns
    }
}