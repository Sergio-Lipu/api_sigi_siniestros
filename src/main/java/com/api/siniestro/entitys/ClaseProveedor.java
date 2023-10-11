package com.api.siniestro.entitys;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cat_clase_proveedor")
public class ClaseProveedor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_clase_proveedor")
	private Long idClaseProveedor;
	@Column(name = "activo")
	private Integer activo;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "fecha_registro")
	private LocalDateTime fechaRegistro;
	@Column(name = "nombre")
	private String nombre;
	
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
	@Override
	public String toString() {
		return "ClaseProveedor [idClaseProveedor=" + idClaseProveedor + ", activo=" + activo + ", descripcion="
				+ descripcion + ", fecha_registro=" + fechaRegistro + ", nombre=" + nombre + "]";
	}
	
}
