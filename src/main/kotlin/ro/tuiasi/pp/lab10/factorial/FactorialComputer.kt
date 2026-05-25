// FactorialComputer.kt
package ro.tuiasi.pp.lab10.factorial

import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.util.concurrent.ConcurrentHashMap

suspend fun computeFactorials(values: List<Int>): Map<Int, Long> = coroutineScope {
    val canal = Channel<Int>(capacity = values.size)
    val rezultate = ConcurrentHashMap<Int, Long>()

    launch {
        for (v in values) {
            canal.send(v)
        }
        canal.close()
    }

    val joburi = (1..4).map {
        async {
            for (n in canal) {
                rezultate[n] = factorial(n)
            }
        }
    }

    joburi.forEach { it.await() }

    rezultate
}

fun factorial(n: Int): Long {
    require(n >= 0) { "Factorialul este definit doar pentru n >= 0" }

    var rezultat = 1L

    for (i in 2..n) {
        rezultat *= i
    }

    return rezultat
}