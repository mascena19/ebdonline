package com.ebd.ebdonline;
import com.ebd.ebdonline.repositories.PessoaRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Formatter;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ebd.ebdonline.domain.Pessoa;
import com.ebd.ebdonline.domain.enums.Perfil;

@SpringBootApplication
public class EbdonlineApplication implements CommandLineRunner {

    private final PessoaRepository pessoaRepository;

    EbdonlineApplication(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

	public static void main(String[] args) {
		SpringApplication.run(EbdonlineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    	Pessoa p1 = new Pessoa(null, "Rodrigo Mascena", "00802649130", LocalDate.parse("25/10/1985", formatter), "mascena19@gmail.com", "1234") ;
    	p1.addPerfil(Perfil.ADMIN);
    	p1.addPerfil(Perfil.ALUNO);
    	
    	pessoaRepository.saveAll(Arrays.asList(p1));
    }
}
