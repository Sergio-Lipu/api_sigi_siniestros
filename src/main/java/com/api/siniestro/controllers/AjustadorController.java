package com.api.siniestro.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.siniestro.services.AjustadorService;
import com.api.siniestro.dtos.AjustadorDTO;
import com.api.siniestro.entitys.Ajustador;

@RestController
@RequestMapping("/api/v1/ajustadores")
public class AjustadorController {

    private final AjustadorService ajustadorService;

    @Autowired
    public AjustadorController(AjustadorService ajustadorService) {
        this.ajustadorService = ajustadorService;
    }

    @GetMapping("/{id}") 
    public ResponseEntity<AjustadorDTO> obtenerAjustador(@PathVariable Long id) { 
        return ajustadorService.obtenerAjustador(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/lista")
    public List<AjustadorDTO> obtenerAjustadores(){
        return ajustadorService.obtenerAjustadores();
    }

    @PostMapping("/crear")
    public ResponseEntity<AjustadorDTO> crearAjustador(@RequestBody AjustadorDTO ajustadorDTO) {
        return ResponseEntity.ok(ajustadorService.crearAjustador(ajustadorDTO));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<AjustadorDTO> actualizarAjustador(@PathVariable Long id, @RequestBody AjustadorDTO ajustadorDTO){
        return ajustadorService.actualizarAjustador(id, ajustadorDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private AjustadorDTO mapearAjustadorDTO(Ajustador ajustador) {
        AjustadorDTO ajustadorDTO = new AjustadorDTO();
        ajustadorDTO.setIdAjustador(ajustador.getIdAjustador());
        ajustadorDTO.setNombre(ajustador.getNombre());
        ajustadorDTO.setActivo(ajustador.getActivo()); 
        ajustadorDTO.setIdUnidadNegocio(ajustador.getIdUnidadNegocio());
        return ajustadorDTO;
    }

    private Ajustador mapearAjustadorEntity(AjustadorDTO dto) {
        Ajustador ajustador = new Ajustador();
        ajustador.setIdAjustador(dto.getIdAjustador());
        ajustador.setNombre(dto.getNombre());
        ajustador.setActivo(dto.getActivo());
        ajustador.setIdUnidadNegocio(dto.getIdUnidadNegocio());
        return ajustador;
    }
}
