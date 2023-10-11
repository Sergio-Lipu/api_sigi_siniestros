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
import com.api.siniestro.services.ClasificacionService;

@RestController
@RequestMapping("/api/v1/clasificaciones")
public class ClasificacionController {
	
	@Autowired
	ClasificacionService clasificacionService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Clasificacion> obtenerClasificacion(@PathVariable Long id){
		return clasificacionService.obtenerClasificacion(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@GetMapping("/lista")
	public List<Clasificacion> obtenerClasificaciones(){
		return clasificacionService.obtenerClasificaciones();
	}
	
	@PostMapping("/crear")
    public ResponseEntity<Clasificacion> crearClasificacion(@RequestBody Clasificacion clasificacion) {
        Clasificacion nuevaClasificacion = clasificacionService.crearClasificacion(clasificacion);
        return ResponseEntity.ok(nuevaClasificacion);
    }
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<Clasificacion> actualizarClasificacion(@PathVariable Long id,@RequestBody Clasificacion clasificacion){
		return clasificacionService.actualizarClasifiacion(id, clasificacion)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

}
