package com.AppMoney_Api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AppMoney_Api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Optional<Usuario> findByEmail(String email);
}
