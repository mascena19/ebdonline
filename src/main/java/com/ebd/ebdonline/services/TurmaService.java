package com.ebd.ebdonline.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebd.ebdonline.domain.Turma;
import com.ebd.ebdonline.repositories.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository repository;
	
	public Turma findById(Integer id) {
		
		Optional<Turma> obj = repository.findById(id);
		return obj.orElse(null);
	}

}
