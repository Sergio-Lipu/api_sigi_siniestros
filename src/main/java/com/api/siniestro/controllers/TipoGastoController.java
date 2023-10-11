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
import com.api.siniestro.entitys.TipoGasto;
import com.api.siniestro.services.TipoGastoService;

@RestController
@RequestMapping("/api/v1/tiposGastos")
public class TipoGastoController {
	@Autowired
	TipoGastoService tipoGastoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoGasto> obtenerTipoGasto(@PathVariable Long id){
		return tipoGastoService.obtenerTipoGasto(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@GetMapping("/lista")
	public List<TipoGasto> obtenerTipoGastos(){
		return tipoGastoService.obtenerTipoGastos();
	}
	
	@PostMapping
	public ResponseEntity<TipoGasto> crearTipoGasto(@RequestBody TipoGasto tipoGasto){
		TipoGasto nuevoTipoGasto = tipoGastoService.crearTipoGasto(tipoGasto);
		return ResponseEntity.ok(nuevoTipoGasto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TipoGasto> 
	actualizarTipoGasto(@PathVariable Long id, @RequestBody TipoGasto tipoGasto){
		return tipoGastoService.actualizarTipoGasto(id, tipoGasto)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

}
