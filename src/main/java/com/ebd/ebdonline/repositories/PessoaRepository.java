package com.ebd.ebdonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebd.ebdonline.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
