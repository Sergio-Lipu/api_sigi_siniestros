package com.api.siniestro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.siniestro.entitys.TipoIncidente;

public interface TipoIncidenteRepository extends JpaRepository<TipoIncidente, Long> {

}
