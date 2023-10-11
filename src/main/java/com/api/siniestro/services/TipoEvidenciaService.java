package com.api.siniestro.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.siniestro.entitys.TipoEvidencia;
import com.api.siniestro.repositories.TipoEvidenciaRepository;

@Service
public class TipoEvidenciaService {
	@Autowired
	TipoEvidenciaRepository tipoEvidenciaRepository;
	
	public List<TipoEvidencia> obtenerTipoEvidencias(){
		return tipoEvidenciaRepository.findAll();
	}
	
	public Optional<TipoEvidencia> obtenerTipoEvidencia(Long id){
		return tipoEvidenciaRepository.findById(id);
	}
	
	@Transactional
	public TipoEvidencia crearTipoEvidencia(TipoEvidencia tipoEvidencia) {
		return tipoEvidenciaRepository.save(tipoEvidencia);
	}
	
	@Transactional
	public Optional <TipoEvidencia> actualizarTipoEvidencia(Long id, TipoEvidencia tipoEvidencia) {
		Optional<TipoEvidencia> tipoEvidenciaOpt = obtenerTipoEvidencia(id);
		if(!tipoEvidenciaOpt.isPresent()) {
			return Optional.empty();
		}
		
		TipoEvidencia actualizarTipoEvidencia = tipoEvidenciaOpt.get();
		actualizarTipoEvidencia.setIdTipoEvidencias(tipoEvidencia.getIdTipoEvidencias());
		actualizarTipoEvidencia.setTipoEvidencia(tipoEvidencia.getTipoEvidencia());
		actualizarTipoEvidencia.setActivo(tipoEvidencia.getActivo());

		return Optional.of(tipoEvidenciaRepository.save(actualizarTipoEvidencia));
	}

}
