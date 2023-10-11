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
import com.api.siniestro.entitys.TipoIncidente;
import com.api.siniestro.services.TipoIncidenteService;

@RestController
@RequestMapping("/api/v1/tiposIncidentes")
public class TipoIncidenteController {
	
	@Autowired
	TipoIncidenteService tipoIncidenteService;
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoIncidente> obtenerTipoIncidente(@PathVariable Long id){
		return tipoIncidenteService.obtenerTipoIncidente(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@GetMapping("/lista")
	public List<TipoIncidente> obtenerTiposIncidentes(){
		return tipoIncidenteService.obtenerTiposIncidentes();
	}
	
	@PostMapping
	public ResponseEntity<TipoIncidente> crearTipoIncidente(@RequestBody TipoIncidente tipoIncidente){
		TipoIncidente nuevoTipoIncidente = tipoIncidenteService.crearTipoIncidente(tipoIncidente);
		return ResponseEntity.ok(nuevoTipoIncidente);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<TipoIncidente> actualizarTipoIncidente(@PathVariable Long id,@RequestBody
			TipoIncidente tipoIncidente){
		return tipoIncidenteService.actualizarTipoIncidente(id, tipoIncidente)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

}
