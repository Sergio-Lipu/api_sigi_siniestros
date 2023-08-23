package com.api.siniestro.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ajustadores")
public class Ajustador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_ajustador")
	private Long idAjustador;
	@Column(name = "ajustadores")
	private String nombre;
	@Column(name = "activo")
	private Integer activo;
	@Column(name = "idunidad_negocio")
	private Integer idUnidadNegocio;

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
	public void setActivo(Integer estatus) {
		this.activo = estatus;
	}
	public Integer getIdUnidadNegocio() {
		return idUnidadNegocio;
	}
	public void setIdUnidadNegocio(Integer idUnidadNegocio) {
		this.idUnidadNegocio = idUnidadNegocio;
	}
	
	@Override
	public String toString() {
		return "Ajustador [idAjustador=" + idAjustador + ", nombre=" + nombre + ", activo=" + activo
				+ ", idUnidadNegocio=" + idUnidadNegocio + "]";
	}
	
	

}
