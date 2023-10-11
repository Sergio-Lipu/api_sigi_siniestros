package com.api.siniestro.dtos;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;

public class ClaseProveedorDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long idClaseProveedor;
    private Integer activo;
    private String descripcion;
    private LocalDateTime fechaRegistro;
    private String nombre;
    
    public ClaseProveedorDTO() {
    }

    public ClaseProveedorDTO(Long idClaseProveedor, Integer activo, String descripcion, LocalDateTime fechaRegistro, String nombre) {
        this.idClaseProveedor = idClaseProveedor;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.nombre = nombre;
    }

    // Getters y setters
    public Long getIdClaseProveedor() {
        return idClaseProveedor;
    }

    public void setIdClaseProveedor(Long idClaseProveedor) {
        this.idClaseProveedor = idClaseProveedor;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
