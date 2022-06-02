package com.testezappts.testeapi.resources;


import java.util.List;

import com.testezappts.testeapi.database.RepositorioCarta;
import com.testezappts.testeapi.entidade.Carta;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Cartas")
@CrossOrigin(origins = "*")
public class CartaREST {
    @Autowired
    private RepositorioCarta repositorio;

    @GetMapping("/cartas")
    @ApiOperation(value = "Retorna lista")
    public List<Carta> listar(String nome){
        if(nome == null){
            return repositorio.findByOrderByPrecoDesc();
        }else{
            return repositorio.findByNomeOrderByPrecoDesc(nome);
        }
    }

    @PostMapping("/carta")
    @ApiOperation(value = "Salva carta")
    public void salvar(@RequestBody Carta carta){
        repositorio.save(carta);
    }

    @PutMapping("/carta")
    @ApiOperation(value = "altera carta")
    public void altera(@RequestBody Carta carta){
        if(carta.getId()>0)
            repositorio.save(carta);
    }

    @DeleteMapping("/carta/{id}")
    @ApiOperation(value = "exclui carta")
    public void excluir(@RequestBody Carta carta){
        repositorio.delete(carta);
    }
}
