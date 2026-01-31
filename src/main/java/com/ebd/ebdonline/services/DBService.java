package com.ebd.ebdonline.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebd.ebdonline.domain.Matricula;
import com.ebd.ebdonline.domain.Pessoa;
import com.ebd.ebdonline.domain.Turma;
import com.ebd.ebdonline.domain.enums.FaixaEtaria;
import com.ebd.ebdonline.domain.enums.Perfil;
import com.ebd.ebdonline.repositories.MatriculaRepository;
import com.ebd.ebdonline.repositories.PessoaRepository;
import com.ebd.ebdonline.repositories.TurmaRepository;

@Service
public class DBService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private TurmaRepository turmaRepository;

	public void instanciaDB() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    
    	Pessoa p1 = new Pessoa(null, "Rodrigo Mascena", "00802649130", LocalDate.parse("25/10/1985", formatter), "mascena19@gmail.com", "1234") ;
    	p1.addPerfil(Perfil.ADMIN);
    	p1.addPerfil(Perfil.ALUNO);
    	
    	Pessoa p2 = new Pessoa(null, "Joyce Smith", "01476152160", LocalDate.parse("15/03/1985", formatter), "joycesm@gmail.com", "1234") ;
    	    	p2.addPerfil(Perfil.ALUNO);
    	
    	Pessoa p3 = new Pessoa(null, "Elisa Mascena", "19255405020", LocalDate.parse("15/08/2017", formatter), "elisaSmith@gmail.com", "1234") ;
    	    	p3.addPerfil(Perfil.ALUNO);
    	
    	Pessoa p4 = new Pessoa(null, "Jorge Gabriel", "35100620005", LocalDate.parse("11/02/1988", formatter), "jorgeGabriel@gmail.com", "1234") ;
    	    	p4.addPerfil(Perfil.VISITANTE);
    	
    	pessoaRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
    	
    	Turma turma = new Turma();
    	turma.setNome("Turma 2026");
    	turma.setProfessor(p2);
    	turma.setFaixaEtaria(FaixaEtaria.ADULTOS);
    	turma.setAtiva(true);
       	turmaRepository.save(turma);
    	
    	
    	Matricula m1 = new Matricula();
    	m1.setAtiva(true);
    	m1.setPessoa(p1);
    	m1.setTurma(turma);
    	
    	matriculaRepository.saveAll(Arrays.asList(m1));
    	    	
	}
	
}
