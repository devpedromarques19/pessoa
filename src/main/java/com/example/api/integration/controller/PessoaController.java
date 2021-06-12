package com.example.api.integration.controller;

import com.example.api.integration.entities.PessoaEntity;
import com.example.api.integration.model.Pessoa;
import com.example.api.integration.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @RequestMapping (value = "getTodasPessoas", method = RequestMethod.GET)
    public List<Pessoa> getTodasPessoas (){
    return pessoaService.getTodasPessoas();
    }

    @RequestMapping (value = "adicionarPessoa", method = RequestMethod.POST)
    public String adicionarPessoa (@RequestBody PessoaEntity pessoa){
        return pessoaService.adicionarPessoa(pessoa);
    }

    @RequestMapping (value = "atualizarPessoa", method = RequestMethod.PUT)
    public String atualizarPessoa (@RequestBody PessoaEntity pessoa){
        return pessoaService.atualizarPessoa(pessoa);
    }

    @RequestMapping (value = "removerPessoa", method = RequestMethod.DELETE)
    public String removerPessoa (@RequestBody PessoaEntity pessoa){
        return pessoaService.removerPessoa(pessoa);
    }


}
