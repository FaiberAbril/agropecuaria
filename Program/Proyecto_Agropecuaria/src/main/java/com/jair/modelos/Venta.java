package com.jair.modelos;

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
@Table(name="ventas")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdVenta;
	
	@JoinColumn
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Producto productoVenta;
	
	@Column
	private int Cantidad;
	
	@Column
	private double precioProductoVenta;
	
	@Column
	private double PagoTotal;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIME)
	private Date FechaVenta;
	
	public Venta() {
		// TODO Auto-generated constructor stub
	}

	
	
}
