// PipelineProcessor.kt
package ro.tuiasi.pp.lab10.pipeline

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class PipelineProcessor {

    fun process(input: List<Int>, alpha: Int): List<Int> = runBlocking {
        val canalInmultire = Channel<Int>(Channel.BUFFERED)
        val canalSortat = Channel<Int>(Channel.BUFFERED)

        launch {
            for (element in input) {
                canalInmultire.send(element * alpha)
            }
            canalInmultire.close()
        }

        launch {
            val listaTemp = mutableListOf<Int>()

            for (element in canalInmultire) {
                listaTemp.add(element)
            }

            listaTemp.sort()

            for (element in listaTemp) {
                canalSortat.send(element)
            }

            canalSortat.close()
        }

        val rezultat = mutableListOf<Int>()

        for (element in canalSortat) {
            rezultat.add(element)
        }

        rezultat
    }
}