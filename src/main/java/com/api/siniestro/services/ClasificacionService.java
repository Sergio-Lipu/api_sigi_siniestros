package com.api.siniestro.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.siniestro.entitys.Clasificacion;
import com.api.siniestro.repositories.ClasificacionRepository;

@Service
public class ClasificacionService {
	@Autowired
	ClasificacionRepository clasificacionRepository;
	
	public List<Clasificacion> obtenerClasificaciones(){
		return clasificacionRepository.findAll();
	}
	
	public Optional<Clasificacion> obtenerClasificacion(Long id){
		return clasificacionRepository.findById(id);
	}
	
	@Transactional
	public Clasificacion crearClasificacion(Clasificacion clasifiacion){
		return clasificacionRepository.save(clasifiacion);
	 }
	
	@Transactional
	public Clasificacion actualizarClasifiacion(Clasificacion aseguradora){
		return clasificacionRepository.save(aseguradora);
	 }
}
