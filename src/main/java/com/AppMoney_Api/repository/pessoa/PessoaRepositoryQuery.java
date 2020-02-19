package com.AppMoney_Api.repository.pessoa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.AppMoney_Api.model.Pessoa;
import com.AppMoney_Api.repository.filter.PessoaFilter;

public interface PessoaRepositoryQuery {

	public Page<Pessoa> filtrar(PessoaFilter PessoaFilter, Pageable pageable);
}
