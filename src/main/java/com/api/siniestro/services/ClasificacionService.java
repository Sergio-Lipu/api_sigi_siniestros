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
	public Optional<Clasificacion> actualizarClasifiacion(Long id, Clasificacion clasificacion){
		Optional<Clasificacion> clasificacionOpt = obtenerClasificacion(id);
		if (!clasificacionOpt.isPresent()) {
			return Optional.empty();
		}
		
		Clasificacion actualizarClasificacion = clasificacionOpt.get();
		
		actualizarClasificacion.setTipoIncidente(clasificacion.getTipoIncidente());
		actualizarClasificacion.setTipo(clasificacion.getTipo());
		actualizarClasificacion.setActivo(clasificacion.getActivo());
		
		return Optional.of(clasificacionRepository.save(actualizarClasificacion));
	 }
}
