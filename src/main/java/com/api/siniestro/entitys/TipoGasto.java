package com.api.siniestro.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_gastos")
public class TipoGasto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tipo_gasto")
	private Long idTipoGasto;
	@Column(name = "tipo_gasto")
	private String tipoGasto;
	@Column(name = "activo")
	private Integer activo;
	
	public TipoGasto() {
		
	}
	
	public TipoGasto(Long idTipoGasto, String tipoGasto, Integer activo) {
		this.idTipoGasto = idTipoGasto;
		this.tipoGasto = tipoGasto;
		this.activo = activo;
	}
	
	public Long getIdTipoGasto() {
		return idTipoGasto;
	}
	
	public void setIdTipoGasto(Long idTipoGasto) {
		this.idTipoGasto = idTipoGasto;
	}
	
	public String getTipoGasto() {
		return tipoGasto;
	}
	
	public void setTipoGasto(String tipoGasto) {
		this.tipoGasto = tipoGasto;
	}
	
	public Integer getActivo() {
		return activo;
	}
	
	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	
	@Override
	public String toString() {
		return "TipoGasto [idTipoGasto=" + idTipoGasto + 
				", tipoGasto=" + tipoGasto + ", activo=" + activo +"]";
	}

}
