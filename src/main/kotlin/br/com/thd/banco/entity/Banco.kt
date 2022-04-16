package br.com.thd.banco.entity

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "BANCO")
@NamedQuery(name = "Banco.findAll", query = "SELECT t FROM Banco t")
class Banco(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(name = "CODIGO")
    var codigo: String? = null,

    @Column(name = "NOME")
    var nome: String? = null,

    @Column(name = "URL")
    var url: String? = null
) : Serializable {

    constructor() : this(null, null, null, null)

    companion object {
        private const val serialVersionUID = 1L
    }
}