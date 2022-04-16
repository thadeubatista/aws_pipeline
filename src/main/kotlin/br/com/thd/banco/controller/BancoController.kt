package br.com.thd.banco.controller

import br.com.thd.banco.entity.Banco
import br.com.thd.banco.exception.ExcecaoGenericaServidorException
import br.com.thd.banco.exception.RecursoNaoEncontradoException
import br.com.thd.banco.service.BancoService
import br.com.thd.banco.util.Filtro
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = arrayOf("/banco"), produces = arrayOf("application/json;charset=UTF-8"))
class BancoController(val service: BancoService) {


    @GetMapping
    fun consultarLista(@RequestParam(required = false) filter: String?): MutableList<Banco>? {
        return try {
            if (filter == null){
                service.consultarLista()
            } else {
                val filtro = Filtro(filter)
                service.consultarLista(filtro)
            }

        } catch (e: java.lang.Exception) {
            throw ExcecaoGenericaServidorException(
                "Erro no Servidor [Consultar Lista Banco] - Exceção: " + e.message
            )
        }
    }

    @GetMapping("/{id}")
    fun consultarObjeto(@PathVariable id: Int): Banco {
        return try {
            service.consultarObjeto(id)
        } catch (e: NoSuchElementException) {
            throw RecursoNaoEncontradoException("Registro não localizado [Consultar Objeto Banco].")
        } catch (e: Exception) {
            throw ExcecaoGenericaServidorException(
                "Erro no Servidor [Consultar Objeto Banco] - Exceção: " + e.message
            )
        }
    }

    @PostMapping
    fun inserir(@RequestBody objJson: Banco): Banco? {
        return try {
            service.salvar(objJson)
        } catch (e: Exception) {
            throw ExcecaoGenericaServidorException("Erro no Servidor [Inserir Banco] - Exceção: " + e.message)
        }
    }

    /*

    @PutMapping("/{id}")
    fun alterar(@RequestBody objJson: Banco, @PathVariable id: Int?): Banco {
        return try {
            if (!objJson.getId().equals(id)) {
                throw RequisicaoRuimException(
                    "Objeto inválido [Alterar Banco] - ID do objeto difere do ID da URL."
                )
            }
            val objeto: Banco = service.consultarObjeto(objJson.getId())
            if (objeto != null) {
                service.salvar(objJson)
            } else {
                throw RequisicaoRuimException("Objeto com ID inválido [Alterar Banco].")
            }
        } catch (e: Exception) {
            throw ExcecaoGenericaServidorException("Erro no Servidor [Alterar Banco] - Exceção: " + e.message)
        }
    }

    @DeleteMapping("/{id}")
    fun excluir(@PathVariable id: Int?) {
        try {
            service.excluir(id)
        } catch (e: Exception) {
            throw ExcecaoGenericaServidorException("Erro no Servidor [Excluir Banco] - Exceção: " + e.message)
        }
    }*/
}