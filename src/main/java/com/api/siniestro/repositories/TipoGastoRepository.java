package com.api.siniestro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.siniestro.entitys.TipoGasto;

public interface TipoGastoRepository extends JpaRepository<TipoGasto, Long> {

}
