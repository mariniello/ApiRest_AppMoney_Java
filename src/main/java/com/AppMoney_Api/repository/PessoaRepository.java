package com.AppMoney_Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AppMoney_Api.model.Pessoa;
import com.AppMoney_Api.repository.pessoa.PessoaRepositoryQuery;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PessoaRepositoryQuery{

}
