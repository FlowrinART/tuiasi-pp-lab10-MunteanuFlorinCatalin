// EliteFactory.kt
package ro.tuiasi.pp.lab10.factory

import ro.tuiasi.pp.lab10.chain.CEOHandler
import ro.tuiasi.pp.lab10.chain.Handler

class EliteFactory : Factory {

    override fun createHandler(): Handler {
        return CEOHandler()
    }
}