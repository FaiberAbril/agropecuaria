package com.jair.modelos;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="rol_profesional")
public class Rol_Profesional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdRolProfesional;
	
	@ManyToOne
	@JoinColumn(name="profesional")
	private Profesionales profesional;
	
	@ManyToOne
	@JoinColumn(name="rol")
	private Roles rol;
	
	public Rol_Profesional() {
		// TODO Auto-generated constructor stub
	}

	public Rol_Profesional(Long idRolProfesional, Profesionales profesional, Roles rol) {
		super();
		IdRolProfesional = idRolProfesional;
		this.profesional = profesional;
		this.rol = rol;
	}

	public Long getIdRolProfesional() {
		return IdRolProfesional;
	}

	public void setIdRolProfesional(Long idRolProfesional) {
		IdRolProfesional = idRolProfesional;
	}

	public Profesionales getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesionales profesional) {
		this.profesional = profesional;
	}

	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}
	
}
