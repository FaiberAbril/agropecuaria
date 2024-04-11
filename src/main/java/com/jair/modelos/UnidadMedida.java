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
	private String NombreUnidadMedida;
	
	@Column(length = 5, nullable = false)
	private String SimboloUnidadMedida; 
	
	public UnidadMedida() {
		// TODO Auto-generated constructor stub
	}

	public UnidadMedida(long idUnidadesMedida, String nombreUnidadMedida, String simboloUnidadMedida) {
		super();
		IdUnidadesMedida = idUnidadesMedida;
		NombreUnidadMedida = nombreUnidadMedida;
		SimboloUnidadMedida = simboloUnidadMedida;
	}

	public long getIdUnidadesMedida() {
		return IdUnidadesMedida;
	}

	public void setIdUnidadesMedida(long idUnidadesMedida) {
		IdUnidadesMedida = idUnidadesMedida;
	}

	public String getNombreUnidadMedida() {
		return NombreUnidadMedida;
	}

	public void setNombreUnidadMedida(String nombreUnidadMedida) {
		NombreUnidadMedida = nombreUnidadMedida;
	}

	public String getSimboloUnidadMedida() {
		return SimboloUnidadMedida;
	}

	public void setSimboloUnidadMedida(String simboloUnidadMedida) {
		SimboloUnidadMedida = simboloUnidadMedida;
	}
	
}
