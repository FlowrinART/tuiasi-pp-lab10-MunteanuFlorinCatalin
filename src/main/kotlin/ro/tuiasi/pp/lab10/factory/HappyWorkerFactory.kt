// HappyWorkerFactory.kt
package ro.tuiasi.pp.lab10.factory

import ro.tuiasi.pp.lab10.chain.HappyWorkerHandler
import ro.tuiasi.pp.lab10.chain.Handler

class HappyWorkerFactory : Factory {

    override fun createHandler(): Handler {
        return HappyWorkerHandler()
    }
}