package com.api.siniestro.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_incidentes")
public class TipoIncidente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tipo_incidente")
	private Long idTipoIncidente;
	@Column(name = "tipo_incidente")
	private String tipoIncidente;
	@Column(name = "activo")
	private Integer activo;
	
	public TipoIncidente() {
		
	}
	
	public TipoIncidente(Long idTipoIncidente, String tipoIncidente, Integer activo) {
		this.idTipoIncidente = idTipoIncidente;
		this.tipoIncidente = tipoIncidente;
		this.activo = activo;
	}

	public Long getIdTipoIncidente() {
		return idTipoIncidente;
	}

	public void setIdTipoIncidente(Long idTipoIncidente) {
		this.idTipoIncidente = idTipoIncidente;
	}

	public String getTipoIncidente() {
		return tipoIncidente;
	}

	public void setTipoIncidente(String tipoIncidente) {
		this.tipoIncidente = tipoIncidente;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "TipoIncidente [idTipoIncidente=" + idTipoIncidente + ", tipoIncidente=" + tipoIncidente + ", activo="
				+ activo + "]";
	}
	
}
