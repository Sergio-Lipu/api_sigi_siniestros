package com.api.siniestro.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.siniestro.entitys.Aseguradora;
import com.api.siniestro.services.AseguradoraService;

@RestController
@RequestMapping("/aseguradoras")
public class AseguradoraController {
	
	@Autowired
	AseguradoraService aseguradoraService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Aseguradora> obtenerAseguradora(@PathVariable Long id){
		return aseguradoraService.obtenerAseguradora(id)
				.map(aseguradora -> new ResponseEntity<>(aseguradora, HttpStatus.OK)) 
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	@GetMapping("/lista")
	public List<Aseguradora> obtenerAseguradoras(){
		return aseguradoraService.obtenerAseguradoras();
	}

}
