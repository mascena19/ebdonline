package com.ebd.ebdonline.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebd.ebdonline.domain.Pessoa;
import com.ebd.ebdonline.domain.enums.Perfil;
import com.ebd.ebdonline.repositories.PessoaRepository;

@Service
public class DBService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public void instanciaDB() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    
    	Pessoa p1 = new Pessoa(null, "Rodrigo Mascena", "00802649130", LocalDate.parse("25/10/1985", formatter), "mascena19@gmail.com", "1234") ;
    	p1.addPerfil(Perfil.ADMIN);
    	p1.addPerfil(Perfil.ALUNO);
    	
    	pessoaRepository.saveAll(Arrays.asList(p1));
	}
	
}
