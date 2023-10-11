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
import com.api.siniestro.entitys.TipoEvidencia;
import com.api.siniestro.services.TipoEvidenciaService;

@RestController
@RequestMapping("/api/v1/tiposEvidencias")
public class TipoEvidenciaController {
	
	@Autowired
	TipoEvidenciaService tipoEvidenciaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoEvidencia> obtenerTipoEvidencias(@PathVariable Long id){
		return tipoEvidenciaService.obtenerTipoEvidencia(id)
				.map(ResponseEntity::ok)
				.orElseGet(()-> ResponseEntity.notFound().build());
	}
	
	@GetMapping("/lista")
	public List<TipoEvidencia> obtenerTipoEvidencia(){
		return tipoEvidenciaService.obtenerTipoEvidencias();
	}
	
	@PostMapping
	public ResponseEntity<TipoEvidencia> crearTipoEvidencia(@RequestBody TipoEvidencia tipoEvidencia){
		TipoEvidencia nuevoTipoEvidencia = tipoEvidenciaService.crearTipoEvidencia(tipoEvidencia);
		return ResponseEntity.ok(nuevoTipoEvidencia);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TipoEvidencia> actualizarTipoEvidencia(@PathVariable Long id,@RequestBody TipoEvidencia tipoEvidencia){
		return tipoEvidenciaService.actualizarTipoEvidencia(id, tipoEvidencia)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

}
