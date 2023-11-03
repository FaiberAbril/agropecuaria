package com.jair.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdRol;
	
	@Column(length = 10, nullable = false)
	private String NombreRol;
	
	@Column(length = 100, nullable = false)
	private String DescripcionRol;
	
	public Roles() {
		// TODO Auto-generated constructor stub
	}

	public Roles(Long idRol, String nombreRol, String descripcionRol) {
		super();
		IdRol = idRol;
		NombreRol = nombreRol;
		DescripcionRol = descripcionRol;
	}

	public Long getIdRol() {
		return IdRol;
	}

	public void setIdRol(Long idRol) {
		IdRol = idRol;
	}

	public String getNombreRol() {
		return NombreRol;
	}

	public void setNombreRol(String nombreRol) {
		NombreRol = nombreRol;
	}

	public String getDescripcionRol() {
		return DescripcionRol;
	}

	public void setDescripcionRol(String descripcionRol) {
		DescripcionRol = descripcionRol;
	}
	
}
