package com.api.siniestro.dtos;

public class AjustadorDTO {
    private Long idAjustador;
    private String nombre;
    private Integer activo;
    private Integer idUnidadNegocio;


    public AjustadorDTO() {
       
    }

    public AjustadorDTO(Long idAjustador, String nombre, Integer activo, Integer idUnidadNegocio) {
        this.idAjustador = idAjustador;
        this.nombre = nombre;
        this.activo = activo;
        this.idUnidadNegocio = idUnidadNegocio;
    }

    public Long getIdAjustador() {
        return idAjustador;
    }

    public void setIdAjustador(Long idAjustador) {
        this.idAjustador = idAjustador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public Integer getIdUnidadNegocio() {
        return idUnidadNegocio;
    }

    public void setIdUnidadNegocio(Integer idUnidadNegocio) {
        this.idUnidadNegocio = idUnidadNegocio;
    }


}
