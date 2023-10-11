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

import com.api.siniestro.entitys.Clasificacion;
import com.api.siniestro.entitys.IncidenteEstatus;
import com.api.siniestro.services.IncidenteEstatusService;

@RestController
@RequestMapping("/api/v1/incidenteEstatus")
public class IncidenteEstatusController {

	@Autowired
	IncidenteEstatusService incidenteEstatusService;
	
	@GetMapping("/{id}")
	public ResponseEntity<IncidenteEstatus> obtenerIncidenteEstatus(@PathVariable Long id){
		return incidenteEstatusService.obtenerIncidenteEstatus(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@GetMapping("/lista")
	public List<IncidenteEstatus> obtenerIncidentesEstatus(){
		return incidenteEstatusService.obtenerIncidentesEstatus();
	}
	
	@PostMapping
	public ResponseEntity<IncidenteEstatus> crearIncidenteEstatus(@RequestBody IncidenteEstatus incidenteEstatus){
		IncidenteEstatus nuevoIncidenteEstatus = incidenteEstatusService.crearIncidenteEstatus(incidenteEstatus);
		return ResponseEntity.ok(nuevoIncidenteEstatus);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<IncidenteEstatus> actualizarIncidentesEstatus(@PathVariable Long id,@RequestBody IncidenteEstatus incidenteEstatus){
		return incidenteEstatusService.actualizarIncidenteEstatus(id, incidenteEstatus)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
}
