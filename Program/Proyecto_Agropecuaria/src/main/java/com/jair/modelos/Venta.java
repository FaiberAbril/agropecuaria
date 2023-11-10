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
	
	@Column(nullable = true)
	private String DescuentoVenta;
	
	@Column
	private double PagoTotal;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date FechaVenta;
	
	public Venta() {
		// TODO Auto-generated constructor stub
	}

	public Venta(long idVenta, Producto productoVenta, int cantidad, String descuentoVenta, double pagoTotal,
			Date fechaVenta) {
		super();
		IdVenta = idVenta;
		this.productoVenta = productoVenta;
		Cantidad = cantidad;
		DescuentoVenta = descuentoVenta;
		PagoTotal = pagoTotal;
		FechaVenta = fechaVenta;
	}

	public long getIdVenta() {
		return IdVenta;
	}

	public void setIdVenta(long idVenta) {
		IdVenta = idVenta;
	}

	public Producto getProductoVenta() {
		return productoVenta;
	}

	public void setProductoVenta(Producto productoVenta) {
		this.productoVenta = productoVenta;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public String getDescuentoVenta() {
		return DescuentoVenta;
	}

	public void setDescuentoVenta(String descuentoVenta) {
		DescuentoVenta = descuentoVenta;
	}

	public double getPagoTotal() {
		return PagoTotal;
	}

	public void setPagoTotal(double pagoTotal) {
		PagoTotal = pagoTotal;
	}

	public Date getFechaVenta() {
		return FechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		FechaVenta = fechaVenta;
	}	
	
}
