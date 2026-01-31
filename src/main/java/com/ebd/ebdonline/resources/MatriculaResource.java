package com.ebd.ebdonline.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebd.ebdonline.domain.Matricula;
import com.ebd.ebdonline.services.MatriculaService;

@RestController
@RequestMapping(value = "/matricula")
public class MatriculaResource {
	
	@Autowired
	private MatriculaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Matricula> findById(@PathVariable Integer id) {
		Matricula obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}

}
