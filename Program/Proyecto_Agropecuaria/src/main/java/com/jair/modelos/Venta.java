package com.jair.modelos;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "ventas")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdVenta;

	@Column(nullable = true)
	private String DescuentoVenta;

	@Column

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private LocalDate FechaVenta;

	public Venta() {
		// TODO Auto-generated constructor stub
	}

	public Venta(long idVenta, String descuentoVenta, LocalDate fechaVenta) {
		super();
		IdVenta = idVenta;
		DescuentoVenta = descuentoVenta;
		FechaVenta = fechaVenta;
	}
	
	
	public Venta(LocalDate fechaVenta) {
		FechaVenta = fechaVenta;
	}
	

	public long getIdVenta() {
		return IdVenta;
	}

	public void setIdVenta(long idVenta) {
		IdVenta = idVenta;
	}

	public String getDescuentoVenta() {
		return DescuentoVenta;
	}

	public void setDescuentoVenta(String descuentoVenta) {
		DescuentoVenta = descuentoVenta;
	}

	public LocalDate getFechaVenta() {
		return FechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		FechaVenta = fechaVenta;
	}

}
