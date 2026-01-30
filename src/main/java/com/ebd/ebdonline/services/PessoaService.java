package com.ebd.ebdonline.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebd.ebdonline.domain.Pessoa;
import com.ebd.ebdonline.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	public Pessoa findById(Integer id) {
		
		Optional<Pessoa> obj = repository.findById(id);
		return obj.orElse(null);
	}

}
