package com.jair.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="reportes")
public class Reporte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Idreporte;
	
	@Column
	private double TotalInvercion;
	
	public Reporte() {
		// TODO Auto-generated constructor stub
	}

	public Reporte(long idreporte, double totalInvercion) {
		super();
		Idreporte = idreporte;
		TotalInvercion = totalInvercion;
	}

	public long getIdreporte() {
		return Idreporte;
	}

	public void setIdreporte(long idreporte) {
		Idreporte = idreporte;
	}

	public double getTotalInvercion() {
		return TotalInvercion;
	}

	public void setTotalInvercion(double totalInvercion) {
		TotalInvercion = totalInvercion;
	}
	
	
	
}
