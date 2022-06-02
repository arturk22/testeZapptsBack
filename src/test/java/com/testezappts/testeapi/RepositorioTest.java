package com.testezappts.testeapi;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.testezappts.testeapi.database.RepositorioCarta;
import com.testezappts.testeapi.entidade.Carta;


@SpringBootTest
public class RepositorioTest {

    @Autowired
    RepositorioCarta repository;

	@Test
	void inserirCarta() {
        Carta cart = new Carta();
        cart.setId(null);
        cart.setNome("Orgon");
        cart.setEdicao("2");
        cart.setIdioma("português");
        cart.setFoil("não");
        cart.setPreco((float) 154);
        cart.setQuantidade("2");
        repository.save(cart);
	}

    //Deve listar cartas pelo nome
    @Test
    public void listarCartasNome(){
        Carta cart = repository.findByNome("Orgon").get(0);
        assertEquals("Orgon", cart.getNome());

    }

    @Test
    public void updateCarta(){
        Carta cart = repository.findByNome("Orgon").get(0);
        cart.setNome("Orgon Silva");
        repository.save(cart);
        assertEquals("Orgon Silva", cart.getNome());

    }

}
