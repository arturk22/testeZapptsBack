package com.testezappts.testeapi.database;

import java.util.List;

import com.testezappts.testeapi.entidade.Carta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCarta extends JpaRepository<Carta,Long> {

    List<Carta> findByOrderByPrecoDesc();

    List<Carta> findByNome(String nome);

    List<Carta> findByNomeOrderByPrecoDesc(String nome); 
}
