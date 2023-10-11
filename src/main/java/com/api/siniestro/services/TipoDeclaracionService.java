package com.api.siniestro.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.siniestro.entitys.TipoDeclaracion;
import com.api.siniestro.repositories.TipoDeclaracionRepository;

@Service
public class TipoDeclaracionService {
	@Autowired
	TipoDeclaracionRepository tipoDeclaracionRepository;
	
	public List<TipoDeclaracion> obtenerTipoDeclaraciones(){
		return tipoDeclaracionRepository.findAll();
	}
	
	public Optional<TipoDeclaracion> obtenerTipoDeclaracion(Long id){
		return tipoDeclaracionRepository.findById(id);
	}
	
	@Transactional
	public TipoDeclaracion crearTipoDeclaracion(TipoDeclaracion tipoDeclaracion) {
		return tipoDeclaracionRepository.save(tipoDeclaracion);
	}
	
	@Transactional
	public Optional<TipoDeclaracion> actualizarTipoDeclaracion(Long id, TipoDeclaracion tipoDeclaracion) {
		Optional<TipoDeclaracion> declaracionOpt = obtenerTipoDeclaracion(id);
		if (!declaracionOpt.isPresent()) {
			return Optional.empty();
		}
		
		TipoDeclaracion actualizarDeclaracion = declaracionOpt.get();
		
		actualizarDeclaracion.setIdTipoDeclaracion(tipoDeclaracion.getIdTipoDeclaracion());
		actualizarDeclaracion.setTipoDeclaracion(tipoDeclaracion.getTipoDeclaracion());
		actualizarDeclaracion.setActivo(tipoDeclaracion.getActivo());
		
		return Optional.of(tipoDeclaracionRepository.save(actualizarDeclaracion));
	}
	
}
