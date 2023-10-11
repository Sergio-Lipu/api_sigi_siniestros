package com.api.siniestro.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "incidente_estatus")
public class IncidenteEstatus implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_estatus_incidente")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEstatus;
	@Column(name = "estatus")
	private String estatus;
	@Column(name = "fecha_registro")
	private Integer fechaRegistro;
	@Column(name = "activo")
	private Integer activo;
	
	public IncidenteEstatus() {
				
	}
	
	public IncidenteEstatus(Long idEstatus, String estatus, Integer fechaRegistro, Integer activo ) {
		this.idEstatus = idEstatus;
		this.estatus = estatus;
		this.fechaRegistro = fechaRegistro;
		this.activo = activo;
	}
	
	public Long getIdEstatus () {
		return idEstatus;
	}
	
	public void setIdEstatus(Long idEstatus) {
		this.idEstatus = idEstatus;
	}
	
	public String getEstatus() {
		return estatus;
	}
	
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Integer getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Integer fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	
	public String toString() {
		return "IncidenteEstatus [idEstatus=" + idEstatus + ", estatus=" + estatus
				+ ", fechaRegistro=" + fechaRegistro + ", activo=" + activo +"]";
	}

}
