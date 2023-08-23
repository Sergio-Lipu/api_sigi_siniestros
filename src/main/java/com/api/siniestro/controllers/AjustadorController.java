package com.api.siniestro.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.siniestro.entitys.Ajustador;
import com.api.siniestro.services.AjustadorService;

@RestController
@RequestMapping("/ajustadores")
public class AjustadorController {
	@Autowired
	AjustadorService ajustadorService;
	    
	@GetMapping("/{id}") 
	public ResponseEntity<Ajustador> obtenerAjustador(@PathVariable Long id) { 
			return ajustadorService.obtenerAjustador(id)
					.map(ajustador -> new ResponseEntity<>(ajustador, HttpStatus.OK)) 
					.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
			}
		 
	@GetMapping("/lista")
	public List<Ajustador> obtenerAjustadores(){
		return ajustadorService.obtenerAjustadores();
		}

}
