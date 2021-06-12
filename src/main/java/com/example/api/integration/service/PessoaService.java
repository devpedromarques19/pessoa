package com.example.api.integration.service;

import com.example.api.integration.entities.PessoaEntity;
import com.example.api.integration.model.Pessoa;
import com.example.api.integration.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    public List<Pessoa> getTodasPessoas (){
        try {
            List<PessoaEntity> pessoas = pessoaRepository.findAll();
            List<Pessoa> customPessoa = new ArrayList();
            pessoas.stream().forEach(e -> {
                Pessoa pessoa = new Pessoa ();
                BeanUtils.copyProperties(e,pessoa);
                customPessoa.add(pessoa);
            });
            return customPessoa;
        } catch (Exception e){
            throw e;
        }
    }

    public String adicionarPessoa (PessoaEntity pessoa){
        try {
            if(!pessoaRepository.existsByNomeAndSobrenome(pessoa.getNome(),pessoa.getSobrenome())){
                pessoaRepository.save(pessoa);
                return "Pessoa Adicionada!";
            }else{
                return "Esta pessoa ja existe";
            }
        }
        catch (Exception e){
            throw e;
        }
    }

    public String removerPessoa (PessoaEntity pessoa){
        try{
            if(pessoaRepository.existsByNomeAndSobrenome(pessoa.getNome(),pessoa.getSobrenome())){
                pessoaRepository.delete(pessoa);
                return "Pessoa Removida!";
            }else{
                return "Esta pessoa nao existe";
            }
        }
        catch (Exception e){
            throw e;
        }

    }

    public String atualizarPessoa (PessoaEntity pessoa){
        try{
            if(pessoaRepository.existsById(pessoa.getId())){
                pessoaRepository.save(pessoa);
                return "Pessoa Atualizada!";
            }else{
                return "Esta pessoa nao existe";
            }
        }
        catch (Exception e){
            throw e;
        }

    }

}
