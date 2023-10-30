package com.jair.modelos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name= "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long idCliente;
	
	@Column(length = 50)
	private String nombreCliente;
	
	@Column(length = 50)
	private String apellidoCliente;
	
	@Column(length = 100)
	private String direccion;
	
	@Column(length = 11)
	private String telefono;
	
	@Column(length = 50)
	private String email;
	
	@Column(length = 12, nullable = false, unique = true)
	private String CedulaCliente;
	
	@Column
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(long idCliente, String nombreCliente, String apellidoCliente, String direccion, String telefono,
			String email, String cedulaCliente, Date fechaNacimiento) {
		super();
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		CedulaCliente = cedulaCliente;
		this.fechaNacimiento = fechaNacimiento;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCedulaCliente() {
		return CedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		CedulaCliente = cedulaCliente;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}
