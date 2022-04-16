package br.com.thd.banco.service

import br.com.thd.banco.entity.Banco
import br.com.thd.banco.repository.BancoRepository
import br.com.thd.banco.util.Constantes
import br.com.thd.banco.util.Filtro
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.Query

@Service
class BancoService {
    @Autowired
    private val repository: BancoRepository? = null

    @PersistenceContext
    private val entityManager: EntityManager? = null
    fun consultarLista(): MutableList<Banco>? {
        return repository?.findAll(PageRequest.of(0, Constantes.MAXIMO_REGISTROS_RETORNADOS))?.toList()
        //return repository.findAll();
    }

    fun consultarLista(filtro: Filtro): MutableList<Banco>{
        val sql = "select * from BANCO where " + filtro.where
        val query: Query? = entityManager?.createNativeQuery(sql, Banco::class.java)
            ?.setMaxResults(Constantes.MAXIMO_REGISTROS_RETORNADOS)
        //Query query = entityManager.createNativeQuery(sql, Banco.class);
        val lista: MutableList<Banco> = query?.resultList as MutableList<Banco>
        return lista
    }

    fun consultarObjeto(id: Int): Banco {
        return repository?.findById(id)?.get() ?: Banco()
    }

    fun salvar(objeto: Banco): Banco? {
        return repository?.save(objeto)
    }

    fun excluir(id: Int) {
        val objeto: Banco = consultarObjeto(id)
        repository?.delete(objeto)
    }
}