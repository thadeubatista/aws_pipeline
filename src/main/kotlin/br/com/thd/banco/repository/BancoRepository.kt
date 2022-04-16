package br.com.thd.banco.repository;

import br.com.thd.banco.entity.Banco
import org.springframework.data.jpa.repository.JpaRepository

interface BancoRepository : JpaRepository<Banco, Int> {
}