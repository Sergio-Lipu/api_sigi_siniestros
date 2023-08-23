package com.api.siniestro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.siniestro.entitys.Clasificacion;

public interface ClasificacionRepository extends JpaRepository<Clasificacion, Long> {

}
