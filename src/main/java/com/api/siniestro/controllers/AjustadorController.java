package com.api.siniestro.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.siniestro.entitys.Ajustador;
import com.api.siniestro.services.AjustadorService;

@RestController
@RequestMapping("/api/v1/ajustadores")
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
	
	@PostMapping
    public ResponseEntity<Ajustador> crearAjustador(@RequestBody Ajustador ajustador) {
        Ajustador nuevoAjustador = ajustadorService.crearAjustador(ajustador);
        return ResponseEntity.ok(nuevoAjustador);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<Ajustador> actualizarAjustador(@PathVariable Long id,@RequestBody Ajustador ajustador){
		Optional<Ajustador> ajustadorOpt = ajustadorService.obtenerAjustador(id);
		if (!ajustadorOpt.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Ajustador actualizarAjustador = ajustadorOpt.get();

		actualizarAjustador.setNombre(ajustador.getNombre());
		actualizarAjustador.setActivo(ajustador.getActivo());
		actualizarAjustador.setIdUnidadNegocio(ajustador.getIdUnidadNegocio());
		
		Ajustador ajustadorGuardado = ajustadorService.actualizarAjustador(actualizarAjustador);
		
		return ResponseEntity.ok(ajustadorGuardado);
	}

}
