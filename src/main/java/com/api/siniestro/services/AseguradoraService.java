package com.api.siniestro.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
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
	
	@Transactional
	public Aseguradora crearAseguradora(Aseguradora aseguradora){
		return aseguradoraRepository.save(aseguradora);
	 }
	
	@Transactional
	public Aseguradora actualizarAseguradora(Aseguradora aseguradora){
		return aseguradoraRepository.save(aseguradora);
	 }
}
