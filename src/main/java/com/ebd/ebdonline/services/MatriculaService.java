package com.ebd.ebdonline.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebd.ebdonline.domain.Matricula;
import com.ebd.ebdonline.repositories.MatriculaRepository;

@Service
public class MatriculaService {
	
	@Autowired
	private MatriculaRepository repository;
	
	public Matricula findById(Integer id) {
		
		Optional<Matricula> obj = repository.findById(id);
		return obj.orElse(null);
	}

}
