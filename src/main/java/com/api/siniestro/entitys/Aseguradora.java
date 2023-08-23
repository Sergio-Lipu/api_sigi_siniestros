package com.api.siniestro.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aseguradoras")
public class Aseguradora implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_aseguradora")
	private Long idAseguradora;
	
	@Column(name = "aseguradora")
	private String aseguradora;
	
	@Column(name = "activo")
	private Integer activo;
	
	public Aseguradora() {
		
	}
	
	public Aseguradora(Long idAseguradora,String aseguradora, Integer activo) {
		this.idAseguradora = idAseguradora;
		this.aseguradora = aseguradora;
		this.activo = activo;
	}
	
	public Long getIdAseguradora() {
		return idAseguradora;
	}
	public void setIdAseguradora(Long idAseguradora) {
		this.idAseguradora = idAseguradora;
	}
	public String getAseguradora() {
		return aseguradora;
	}
	public void setAseguradora(String aseguradora) {
		this.aseguradora = aseguradora;
	}
	public Integer getActivo() {
		return activo;
	}
	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Aseguradora [idAseguradora=" + idAseguradora + ", aseguradora=" + aseguradora + ", activo=" + activo
				+ "]";
	}
	

}
