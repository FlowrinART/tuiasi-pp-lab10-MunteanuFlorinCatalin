// CEOHandler.kt
package ro.tuiasi.pp.lab10.chain

import kotlinx.coroutines.delay

class CEOHandler : Handler {

    override var next: Handler? = null
    override var previous: Handler? = null

    override suspend fun handleRequest(message: String): String {
        delay(100)

        val cerere = "Request - $message"
        println("[CEO] Trimit cererea: $cerere")

        val raspuns = next?.handleRequest(cerere) ?: cerere

        println("[CEO] Am primit răspunsul: $raspuns")
        return raspuns
    }
}