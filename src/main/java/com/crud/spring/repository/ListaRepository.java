package com.crud.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.spring.model.Usuario;

@Repository
public interface ListaRepository extends JpaRepository<Usuario, Integer> {

}
