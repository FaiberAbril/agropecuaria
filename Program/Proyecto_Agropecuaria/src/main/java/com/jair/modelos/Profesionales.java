package com.jair.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Profesionales {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdProfesionales;
	
	@Column(length = 25, nullable = false)
	private String NombreProfesionales;
	
	@Column(length = 10, nullable = false)
	private String DocumentoProfesionales;
	
	@Column(length = 10, nullable = false)
	private String TelefonoProfesionales;
	
	@Column(length = 20, nullable = false)
	private String EmailProfesionales;
	
	public Profesionales() {
		// TODO Auto-generated constructor stub
	}

	public Profesionales(Long idProfesionales, String nombreProfesionales, String documentoProfesionales,
			String telefonoProfesionales, String emailProfesionales) {
		super();
		IdProfesionales = idProfesionales;
		NombreProfesionales = nombreProfesionales;
		DocumentoProfesionales = documentoProfesionales;
		TelefonoProfesionales = telefonoProfesionales;
		EmailProfesionales = emailProfesionales;
	}

	public Long getIdProfesionales() {
		return IdProfesionales;
	}

	public void setIdProfesionales(Long idProfesionales) {
		IdProfesionales = idProfesionales;
	}

	public String getNombreProfesionales() {
		return NombreProfesionales;
	}

	public void setNombreProfesionales(String nombreProfesionales) {
		NombreProfesionales = nombreProfesionales;
	}

	public String getDocumentoProfesionales() {
		return DocumentoProfesionales;
	}

	public void setDocumentoProfesionales(String documentoProfesionales) {
		DocumentoProfesionales = documentoProfesionales;
	}

	public String getTelefonoProfesionales() {
		return TelefonoProfesionales;
	}

	public void setTelefonoProfesionales(String telefonoProfesionales) {
		TelefonoProfesionales = telefonoProfesionales;
	}

	public String getEmailProfesionales() {
		return EmailProfesionales;
	}

	public void setEmailProfesionales(String emailProfesionales) {
		EmailProfesionales = emailProfesionales;
	}

}
