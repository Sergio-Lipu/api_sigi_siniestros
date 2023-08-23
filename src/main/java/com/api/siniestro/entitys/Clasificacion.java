package com.api.siniestro.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_incidente_clasificacion")
public class Clasificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tipo_incidente_clasificacion")
	private Long idClasificacion;
	@Column(name = "id_tipo_incidente")
	private Integer tipoIncidente;
	@Column(name = "tipo")
	private String tipo;
	@Column(name = "activo")
	private Integer activo;
	
	public Clasificacion() {
		
	}
	public Clasificacion(Long idClasificacion, Integer tipoIncidente, String tipo, Integer activo) {
		this.idClasificacion = idClasificacion;
		this.tipoIncidente = tipoIncidente;
		this.tipo = tipo;
		this.activo = activo;
	}
	
	public Long getIdClasificacion() {
		return idClasificacion;
	}
	public void setIdClasificacion(Long idClasificacion) {
		this.idClasificacion = idClasificacion;
	}
	public Integer getTipoIncidente() {
		return tipoIncidente;
	}
	public void setTipoIncidente(Integer tipoIncidente) {
		this.tipoIncidente = tipoIncidente;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getActivo() {
		return activo;
	}
	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	
	@Override
	public String toString() {
		return "Clasificacion [idClasificacion=" + idClasificacion + ", tipoIncidente=" + tipoIncidente + ", tipo="
				+ tipo + ", activo=" + activo + "]";
	}
	
	
}
