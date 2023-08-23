package com.api.siniestro.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.siniestro.entitys.Clasificacion;
import com.api.siniestro.services.ClasificacionService;

@RestController
@RequestMapping("/clasificaciones")
public class ClasificacionController {
	
	@Autowired
	ClasificacionService clasificacionService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Clasificacion> obtenerClasificacion(@PathVariable Long id){
		return clasificacionService.obtenerClasificacion(id)
				.map(clasificacion -> new ResponseEntity<>(clasificacion,HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	@GetMapping("/lista")
	public List<Clasificacion> obtenerClasificaciones(){
		return clasificacionService.obtenerClasificaciones();
	}

}
