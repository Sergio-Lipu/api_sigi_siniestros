package com.api.siniestro.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.siniestro.dtos.ClaseProveedorDTO;
import com.api.siniestro.services.ClaseProveedorService;

@RestController
@RequestMapping("/api/v1/claseProveedor")
public class ClaseProveedorController {
	
	private final ClaseProveedorService claseProveedorService;
	
	@Autowired
	public ClaseProveedorController(ClaseProveedorService claseProveedorService) {
		this.claseProveedorService = claseProveedorService;
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClaseProveedorDTO> obtenerClaseProveedor(@PathVariable Long id){
		return claseProveedorService.obtenerClaseProveedor(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@GetMapping("/lista")
	public List<ClaseProveedorDTO> obtenerClaseProveedores(){
		return claseProveedorService.obtenerClaseProveedores();
		
	}
	

}
