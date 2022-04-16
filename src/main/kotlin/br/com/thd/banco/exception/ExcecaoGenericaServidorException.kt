package br.com.thd.banco.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
class ExcecaoGenericaServidorException(mensagem: String?) : RuntimeException(mensagem) {
    companion object {
        /**
         *
         */
        private const val serialVersionUID = 1L
    }
}
