package com.example.api.integration.repository;

import com.example.api.integration.entities.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository <PessoaEntity,Integer> {
    public boolean existsByNomeAndSobrenome (String nome, String sobrenome);
    public boolean existsById (int id);
}
