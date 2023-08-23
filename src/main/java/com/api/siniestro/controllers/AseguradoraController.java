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
import com.api.siniestro.entitys.Aseguradora;
import com.api.siniestro.services.AseguradoraService;

@RestController
@RequestMapping("/api/v1/aseguradoras")
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
	
	@PostMapping
    public ResponseEntity<Aseguradora> crearAseguradora(@RequestBody Aseguradora aseguradora) {
        Aseguradora nuevaAseguradora = aseguradoraService.crearAseguradora(aseguradora);
        return ResponseEntity.ok(nuevaAseguradora);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<Aseguradora> actualizarAseguradora(@PathVariable Long id,@RequestBody Aseguradora aseguradora){
		Optional<Aseguradora> aseguradoraOpt = aseguradoraService.obtenerAseguradora(id);
		if (!aseguradoraOpt.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Aseguradora actualizarAseguradora = aseguradoraOpt.get();

		actualizarAseguradora.setAseguradora(aseguradora.getAseguradora());
		actualizarAseguradora.setActivo(aseguradora.getActivo());
		
		Aseguradora aseguradoraGuardada = aseguradoraService.actualizarAseguradora(actualizarAseguradora);
		
		return ResponseEntity.ok(aseguradoraGuardada);
	}

}
