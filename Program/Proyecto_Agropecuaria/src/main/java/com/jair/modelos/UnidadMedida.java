package com.jair.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="unidadesmedidas")
public class UnidadMedida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdUnidadesMedida;
	
	@Column(length = 20, nullable = false)
	private String UnidadMedida;
	
	public UnidadMedida() {
		// TODO Auto-generated constructor stub
	}

	public UnidadMedida(long idUnidadesMedida, String unidadMedida) {
		super();
		IdUnidadesMedida = idUnidadesMedida;
		UnidadMedida = unidadMedida;
	}

	public long getIdUnidadesMedida() {
		return IdUnidadesMedida;
	}

	public void setIdUnidadesMedida(long idUnidadesMedida) {
		IdUnidadesMedida = idUnidadesMedida;
	}

	public String getUnidadMedida() {
		return UnidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		UnidadMedida = unidadMedida;
	}
}
