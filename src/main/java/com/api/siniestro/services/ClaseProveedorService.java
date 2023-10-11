package com.api.siniestro.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.siniestro.dtos.ClaseProveedorDTO;
import com.api.siniestro.entitys.ClaseProveedor;
import com.api.siniestro.repositories.ClaseProveedorRepository;

@Service
public class ClaseProveedorService {
	
	@Autowired
	ClaseProveedorRepository claseProveedorRepository;
	
	public List<ClaseProveedorDTO> obtenerClaseProveedores(){
		 List<ClaseProveedor> claseProveedor = claseProveedorRepository.findAll();
		 return claseProveedor.stream()
				 .map(this::mapearClaseProveedorDTO)
				 .collect(Collectors.toList());
		 }
	
	public Optional<ClaseProveedorDTO> obtenerClaseProveedor(Long id) { 
		return claseProveedorRepository.findById(id)
				.map(this::mapearClaseProveedorDTO);
		}
	
    private ClaseProveedorDTO mapearClaseProveedorDTO(ClaseProveedor claseProveedor) {
        ClaseProveedorDTO proveedorDTO = new ClaseProveedorDTO();
        
        proveedorDTO.setIdClaseProveedor(claseProveedor.getIdClaseProveedor());
        proveedorDTO.setActivo(claseProveedor.getActivo());
        proveedorDTO.setDescripcion(claseProveedor.getDescripcion());
        proveedorDTO.setFechaRegistro(claseProveedor.getFechaRegistro());
        proveedorDTO.setNombre(claseProveedor.getNombre());
        return proveedorDTO;
    }

    private ClaseProveedor mapearClaseProveedor(ClaseProveedor dto) {
        ClaseProveedor claseProveedor = new ClaseProveedor();
        
        claseProveedor.setIdClaseProveedor(dto.getIdClaseProveedor());
        claseProveedor.setActivo(dto.getActivo());
        claseProveedor.setDescripcion(dto.getDescripcion());
        claseProveedor.setFechaRegistro(dto.getFechaRegistro());
        claseProveedor.setNombre(dto.getNombre());
        return claseProveedor;
    }
	

}
