// Factory.kt
package ro.tuiasi.pp.lab10.factory

import ro.tuiasi.pp.lab10.chain.Handler

interface Factory {
    fun createHandler(): Handler
}