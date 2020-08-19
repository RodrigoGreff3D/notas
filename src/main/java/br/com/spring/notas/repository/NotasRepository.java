package br.com.spring.notas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.spring.notas.model.Notas;

public interface NotasRepository extends JpaRepository<Notas, Long> {

	Notas findById(long id);
}
