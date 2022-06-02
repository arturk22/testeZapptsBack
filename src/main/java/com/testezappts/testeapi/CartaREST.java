package com.testezappts.testeapi;


import java.util.List;

import com.testezappts.testeapi.database.RepositorioCarta;
import com.testezappts.testeapi.entidade.Carta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/carta")
public class CartaREST {
    @Autowired
    private RepositorioCarta repositorio;

    @GetMapping
    public List<Carta> listar(Float preco, String nome){
        if(nome == null){
            return repositorio.findByOrderByPrecoDesc();
        }else{
            return repositorio.findByNomeOrderByPrecoDesc(nome);
        }
    }

    @PostMapping
    public void salvar(@RequestBody Carta carta){
        repositorio.save(carta);
    }

    @PutMapping
    public void aletar(@RequestBody Carta carta){
        if(carta.getId()>0)
            repositorio.save(carta);
    }

    @DeleteMapping
    public void excluir(@RequestBody Carta carta){
        repositorio.delete(carta);
    }
}
