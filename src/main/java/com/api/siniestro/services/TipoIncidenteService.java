package com.api.siniestro.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.siniestro.entitys.TipoIncidente;
import com.api.siniestro.repositories.TipoIncidenteRepository;

@Service
public class TipoIncidenteService {
	@Autowired
	TipoIncidenteRepository tipoIncidenteRepository;
	
	public List<TipoIncidente> obtenerTiposIncidentes(){
		return tipoIncidenteRepository.findAll();
	}
	
	public Optional<TipoIncidente> obtenerTipoIncidente(Long id){
		return tipoIncidenteRepository.findById(id);
	}
	
	@Transactional
	public TipoIncidente crearTipoIncidente(TipoIncidente tipoIncidente) {
		return tipoIncidenteRepository.save(tipoIncidente);
	}
	@Transactional
	public Optional<TipoIncidente> actualizarTipoIncidente(Long id, TipoIncidente tipoIncidente) {
		Optional<TipoIncidente> tipoIncidenteOpt = obtenerTipoIncidente(id);
		if (!tipoIncidenteOpt.isPresent()) {
			return Optional.empty();
		}
		
		TipoIncidente actualizarTipoIncidente = tipoIncidenteOpt.get();
		actualizarTipoIncidente.setIdTipoIncidente(tipoIncidente.getIdTipoIncidente());
		actualizarTipoIncidente.setTipoIncidente(tipoIncidente.getTipoIncidente());
		actualizarTipoIncidente.setActivo(tipoIncidente.getActivo());
		
		return Optional.of(tipoIncidenteRepository.save(actualizarTipoIncidente));
	}
}
