package com.api.siniestro.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.siniestro.entitys.TipoGasto;
import com.api.siniestro.repositories.TipoGastoRepository;

@Service
public class TipoGastoService {
	@Autowired
	TipoGastoRepository tipoGastoRepository;
	
	public List<TipoGasto> obtenerTipoGastos(){
		return tipoGastoRepository.findAll();
	}
	
	public Optional<TipoGasto> obtenerTipoGasto(Long id){
		return tipoGastoRepository.findById(id);
	}
	
	@Transactional
	public TipoGasto crearTipoGasto(TipoGasto tipoGasto) {
		return tipoGastoRepository.save(tipoGasto);
	}
	
	@Transactional
	public Optional<TipoGasto> actualizarTipoGasto(Long id, TipoGasto tipoGasto){
		Optional<TipoGasto> tipoGastoOpt = obtenerTipoGasto(id);
		if (!tipoGastoOpt.isPresent()) {
			return Optional.empty(); 
		}
		
		TipoGasto actualizarTipoGasto = tipoGastoOpt.get();
		
		actualizarTipoGasto.setIdTipoGasto(tipoGasto.getIdTipoGasto());
		actualizarTipoGasto.setTipoGasto(tipoGasto.getTipoGasto());
		actualizarTipoGasto.setActivo(tipoGasto.getActivo());
		
		return Optional.of(tipoGastoRepository.save(actualizarTipoGasto));
	}
}
