package com.ebd.ebdonline.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebd.ebdonline.domain.Turma;
import com.ebd.ebdonline.services.TurmaService;

@RestController
@RequestMapping(value = "/turma")
public class TurmaResource {
	
	@Autowired
	private TurmaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Turma> findById(@PathVariable Integer id) {
		Turma obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}

}
