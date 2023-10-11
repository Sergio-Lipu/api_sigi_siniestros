package com.api.siniestro.entitys;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_evidencias")
public class TipoEvidencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_tipo_evidencias")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTipoEvidencias;
	@Column(name = "tipo_evidencia")
	private String tipoEvidencia;
	@Column(name = "activo")
	private Integer activo;
	
	public TipoEvidencia() {
		
	}
	
	public TipoEvidencia(Long idTipoEvidencias, String tipoEvidencia, Integer activo) {
		this.idTipoEvidencias = idTipoEvidencias;
		this.tipoEvidencia = tipoEvidencia;
		this.activo = activo;
	}

	public Long getIdTipoEvidencias() {
		return idTipoEvidencias;
	}

	public void setIdTipoEvidencias(Long idTipoEvidencias) {
		this.idTipoEvidencias = idTipoEvidencias;
	}
	
	public String getTipoEvidencia() {
		return tipoEvidencia;
	}
	
	public void setTipoEvidencia(String tipoEvidencia) {
		this.tipoEvidencia = tipoEvidencia;
	}
	
	public Integer getActivo() {
		return activo;
	}
	
	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	

	@Override
	public String toString() {
		return "TipoEvidencia [idTipoEvidencias=" + idTipoEvidencias + ", tipoEvidencia=" + tipoEvidencia + ", activo="
				+ activo + "]";
	}
	
	
	
}
