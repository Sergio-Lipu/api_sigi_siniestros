package com.api.siniestro.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_declaraciones")
public class TipoDeclaracion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tipo_declaracion")
	private Long idTipoDeclaracion;
	
	@Column(name = "tipo_declaracion")
	private String tipoDeclaracion;
	
	@Column(name = "activo")
	private Integer activo;
	
	public TipoDeclaracion() {
		
	}

	public TipoDeclaracion(Long idTipoDeclaracion, String tipoDeclaracion, Integer activo) {
		this.idTipoDeclaracion = idTipoDeclaracion;
		this.tipoDeclaracion = tipoDeclaracion;
		this.activo = activo;
	}

	public Long getIdTipoDeclaracion() {
		return idTipoDeclaracion;
	}

	public void setIdTipoDeclaracion(Long idTipoDeclaracion) {
		this.idTipoDeclaracion = idTipoDeclaracion;
	}

	public String getTipoDeclaracion() {
		return tipoDeclaracion;
	}

	public void setTipoDeclaracion(String tipoDeclaracion) {
		this.tipoDeclaracion = tipoDeclaracion;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "TipoDeclaracion [idTipoDeclaracion=" + idTipoDeclaracion + ", tipoDeclaracion=" + tipoDeclaracion
				+ ", activo=" + activo + "]";
	}
	
	
	
	

}
