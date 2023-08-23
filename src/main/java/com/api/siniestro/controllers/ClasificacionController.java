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
				.map(clasificacion -> new ResponseEntity<>(clasificacion,HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	@GetMapping("/lista")
	public List<Clasificacion> obtenerClasificaciones(){
		return clasificacionService.obtenerClasificaciones();
	}
	
	@PostMapping
    public ResponseEntity<Clasificacion> crearClasificacion(@RequestBody Clasificacion clasificacion) {
        Clasificacion nuevaClasificacion = clasificacionService.crearClasificacion(clasificacion);
        return ResponseEntity.ok(nuevaClasificacion);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<Clasificacion> actualizarClasificacion(@PathVariable Long id,@RequestBody Clasificacion clasificacion){
		Optional<Clasificacion> clasificacionOpt = clasificacionService.obtenerClasificacion(id);
		if (!clasificacionOpt.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Clasificacion actualizarClasificacion = clasificacionOpt.get();
		
		actualizarClasificacion.setTipoIncidente(clasificacion.getTipoIncidente());
		actualizarClasificacion.setTipo(clasificacion.getTipo());
		actualizarClasificacion.setActivo(clasificacion.getActivo());
		
		Clasificacion clasifiacionGuardada = clasificacionService.actualizarClasifiacion(actualizarClasificacion);
		
		return ResponseEntity.ok(clasifiacionGuardada);
	}

}
