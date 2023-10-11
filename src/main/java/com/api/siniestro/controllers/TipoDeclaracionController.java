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
import com.api.siniestro.entitys.TipoDeclaracion;
import com.api.siniestro.services.TipoDeclaracionService;

@RestController
@RequestMapping("/api/v1/tipoDeclaraciones")
public class TipoDeclaracionController {
	
	@Autowired
	TipoDeclaracionService tipoDeclaracionService;
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoDeclaracion> obtenerTipoDeclaracion(@PathVariable Long id){
		return tipoDeclaracionService.obtenerTipoDeclaracion(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@GetMapping("/lista")
	public List<TipoDeclaracion> obtenerTipoDeclaraciones(){
		return tipoDeclaracionService.obtenerTipoDeclaraciones();
	}
	
	@PostMapping("crear/{id}")
	public ResponseEntity<TipoDeclaracion> crearTipoDeclaracion(@PathVariable Long id, @RequestBody TipoDeclaracion tipoDeclaracion){
		TipoDeclaracion nuevoTipoDeclaracion = tipoDeclaracionService.crearTipoDeclaracion(tipoDeclaracion);
		return ResponseEntity.ok(nuevoTipoDeclaracion);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TipoDeclaracion> actualizarTipoDeclaracion(@PathVariable Long id,@RequestBody TipoDeclaracion tipoDeclaracion){
		return tipoDeclaracionService.actualizarTipoDeclaracion(id, tipoDeclaracion)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

}
