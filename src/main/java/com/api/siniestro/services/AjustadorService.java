package com.api.siniestro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.siniestro.entitys.Ajustador;
import com.api.siniestro.repositories.AjustadorRepository;

@Service
public class AjustadorService {
	@Autowired
	 AjustadorRepository ajustadorRepository;
	
	 public List<Ajustador> obtenerAjustadores(){
		 return ajustadorRepository.findAll(); 
		 }
	 public Optional<Ajustador> obtenerAjustador(Long id) { 
		 return ajustadorRepository.findById(id);
		 }
}
