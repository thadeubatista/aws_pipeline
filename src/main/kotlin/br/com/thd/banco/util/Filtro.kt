package br.com.thd.banco.util

import java.io.Serializable

class Filtro : Serializable {
    var campo: String? = null
    var valor: String? = null
    var dataInicial: String? = null
    var dataFinal: String? = null
    var where: String? = null
        get() = if (field == null) "" else field
    var condicao: String? = null

    constructor() {}
    constructor(filter: String) {
        val filtro = filter.replace("||", ":")
        val partesDoFiltro = filtro.split("\\?".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()
        for (i in partesDoFiltro.indices) {
            val condicoes = partesDoFiltro[i].split(":".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray()
            condicao = condicoes[1]
            if (i > 0) {
                where = where + " AND "
            }

            // $cont (LIKE %val%, contains)
            if (condicao == "\$cont") {
                campo = condicoes[0]
                valor = condicoes[2]
                where = where + campo + " like '%" + valor + "%'"
            }

            // $eq (=, equal)
            if (condicao == "\$eq") {
                campo = condicoes[0]
                valor = condicoes[2]
                where = where + campo + " = '" + valor + "'"
            }

            // $between (BETWEEN, between, accepts two values)
            if (condicao == "\$between") {
                val datas = condicoes[2].split(",".toRegex()).dropLastWhile { it.isEmpty() }
                    .toTypedArray()
                campo = condicoes[0]
                dataInicial = datas[0]
                dataFinal = datas[1]
                where = where + campo + " between '" + dataInicial + "' and '" + dataFinal + "'"
            }
        }
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}