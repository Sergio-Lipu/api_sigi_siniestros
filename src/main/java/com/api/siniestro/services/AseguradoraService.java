package com.api.siniestro.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.siniestro.entitys.Aseguradora;
import com.api.siniestro.repositories.AseguradoraRepository;

@Service
public class AseguradoraService {
	@Autowired
	AseguradoraRepository aseguradoraRepository;
	
	public List<Aseguradora> obtenerAseguradoras(){
		return aseguradoraRepository.findAll();
	}
	public Optional<Aseguradora> obtenerAseguradora(Long id) { 
		return aseguradoraRepository.findById(id); 
		}
}
