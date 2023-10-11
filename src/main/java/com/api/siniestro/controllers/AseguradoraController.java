package com.api.siniestro.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
				.map(ResponseEntity::ok) 
				.orElseGet(()-> ResponseEntity.notFound().build()); 
	}
	
	@GetMapping("/lista")
	public List<Aseguradora> obtenerAseguradoras(){
		return aseguradoraService.obtenerAseguradoras();
	}
	
	@PostMapping("/crear")
    public ResponseEntity<Aseguradora> crearAseguradora(@RequestBody Aseguradora aseguradora) {
        Aseguradora nuevaAseguradora = aseguradoraService.crearAseguradora(aseguradora);
        return ResponseEntity.ok(nuevaAseguradora);
    }
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<Aseguradora> actualizarAseguradora(@PathVariable Long id,@RequestBody Aseguradora aseguradora){
		return aseguradoraService.actualizarAseguradora(id, aseguradora)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

}
