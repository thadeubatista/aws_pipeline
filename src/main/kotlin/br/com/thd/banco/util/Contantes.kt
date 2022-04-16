package br.com.thd.banco.util

class Constantes private constructor() {
    init {
        throw IllegalStateException("Constantes")
    }

    companion object {
        const val QUANTIDADE_POR_PAGINA = 50
        var DECIMAIS_QUANTIDADE = 3
        var DECIMAIS_VALOR = 2
        var MAXIMO_REGISTROS_RETORNADOS = 50
    }
}