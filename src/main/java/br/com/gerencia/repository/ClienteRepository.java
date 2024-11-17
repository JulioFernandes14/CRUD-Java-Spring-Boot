package br.com.gerencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerencia.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	public String findByEmail(String email);
	
}
