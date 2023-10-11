package com.api.siniestro.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.siniestro.entitys.IncidenteEstatus;
import com.api.siniestro.repositories.IncidenteEstatusRepository;

@Service
public class IncidenteEstatusService {
	
	@Autowired
	IncidenteEstatusRepository incidenteEstatusRepository;
	
	public Optional<IncidenteEstatus> obtenerIncidenteEstatus(Long id){
		return incidenteEstatusRepository.findById(id);
	}	
	public List<IncidenteEstatus> obtenerIncidentesEstatus(){
		return incidenteEstatusRepository.findAll();
	}
	
	@Transactional
	public IncidenteEstatus crearIncidenteEstatus(IncidenteEstatus incidenteEstatus) {
		return incidenteEstatusRepository.save(incidenteEstatus);
	}
	
	@Transactional
	public Optional<IncidenteEstatus> actualizarIncidenteEstatus(Long id, IncidenteEstatus incidenteEstatus){
		Optional<IncidenteEstatus> incidenteEstatusOpt = obtenerIncidenteEstatus(id);
		if (!incidenteEstatusOpt.isPresent()) {
			return Optional.empty();
		}
		
		IncidenteEstatus incidenteActualizado = incidenteEstatusOpt.get();
		
		incidenteActualizado.setEstatus(incidenteEstatus.getEstatus());
		incidenteActualizado.setFechaRegistro(incidenteEstatus.getFechaRegistro());
		incidenteActualizado.setActivo(incidenteEstatus.getActivo());
		
		return Optional.of(incidenteEstatusRepository.save(incidenteActualizado));
	}
	

}
