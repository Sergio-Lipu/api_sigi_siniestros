package com.api.siniestro.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.siniestro.entitys.Ajustador;
import com.api.siniestro.repositories.AjustadorRepository;
import com.api.siniestro.dtos.AjustadorDTO;

@Service
public class AjustadorService {
	
	@Autowired
	 AjustadorRepository ajustadorRepository;
	
	 public List<AjustadorDTO> obtenerAjustadores(){
		 List<Ajustador> ajustadores = ajustadorRepository.findAll();
		 return ajustadores.stream()
				 .map(this::mapearAjustadorDTO)
				 .collect(Collectors.toList());
		 }
	 
	 public Optional<AjustadorDTO> obtenerAjustador(Long id) { 
		 return ajustadorRepository.findById(id)
				 .map(this::mapearAjustadorDTO);
		 }
	 
	 @Transactional
	 public AjustadorDTO crearAjustador(AjustadorDTO ajustadorDTO){
		 Ajustador ajustador = mapearAjustadorEntity(ajustadorDTO);
		 Ajustador nuevoAjustador = ajustadorRepository.save(ajustador);
		 return mapearAjustadorDTO(nuevoAjustador); 
	 }
	 
	 @Transactional
	 public Optional<AjustadorDTO> actualizarAjustador(Long id, AjustadorDTO ajustadorDTO){
		 Optional<Ajustador> ajustadorOpt = ajustadorRepository.findById(id);
			if (!ajustadorOpt.isPresent()) {
				return Optional.empty();
			}
			
			Ajustador actualizarAjustador = ajustadorOpt.get();

			actualizarAjustador.setNombre(ajustadorDTO.getNombre());
			actualizarAjustador.setActivo(ajustadorDTO.getActivo());
			actualizarAjustador.setIdUnidadNegocio(ajustadorDTO.getIdUnidadNegocio());
			
			Ajustador ajustadorActualizado = ajustadorRepository.save(actualizarAjustador);
			return Optional.of(mapearAjustadorDTO(ajustadorActualizado));
		
	 }

	    // Agrega métodos de mapeo entre DTO y entidad
	    private Ajustador mapearAjustadorEntity(AjustadorDTO ajustadorDTO) {
	        Ajustador ajustador = new Ajustador();
	     
	        ajustador.setIdAjustador(ajustadorDTO.getIdAjustador());
	        ajustador.setNombre(ajustadorDTO.getNombre());
	        ajustador.setActivo(ajustadorDTO.getActivo());
	        ajustador.setIdUnidadNegocio(ajustadorDTO.getIdUnidadNegocio());
	        return ajustador;
	    }

	    private AjustadorDTO mapearAjustadorDTO(Ajustador ajustador) {
	    	
	        AjustadorDTO ajustadorDTO = new AjustadorDTO();
	        
	        ajustadorDTO.setIdAjustador(ajustador.getIdAjustador());
	        ajustadorDTO.setNombre(ajustador.getNombre());
	        ajustadorDTO.setActivo(ajustador.getActivo());
	        ajustadorDTO.setIdUnidadNegocio(ajustador.getIdUnidadNegocio());
	        return ajustadorDTO;
	    }
	}
