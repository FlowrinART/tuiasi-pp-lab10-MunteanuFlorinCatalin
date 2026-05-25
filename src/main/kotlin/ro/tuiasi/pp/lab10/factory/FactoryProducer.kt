// FactoryProducer.kt
package ro.tuiasi.pp.lab10.factory

object FactoryProducer {

    fun getFactory(type: String): Factory {
        return when (type.uppercase()) {
            "ELITE" -> EliteFactory()
            "HAPPY_WORKER" -> HappyWorkerFactory()
            else -> throw IllegalArgumentException("Tip factory necunoscut: $type")
        }
    }
}