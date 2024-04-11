package com.jair.modelos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="detalles")
public class Detalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdDetalle;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn()
	private Venta venta;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn()
	private Producto producto;
	
	@Column
	private int Cantidad;
	
	@Column
	private double subTotal;
	
	
	public Detalle() {
		// TODO Auto-generated constructor stub
	}


	public Detalle(long idDetalle, Venta venta, Producto producto, int cantidad, double subTotal) {
		super();
		IdDetalle = idDetalle;
		this.venta = venta;
		this.producto = producto;
		Cantidad = cantidad;
		this.subTotal = subTotal;
	}


	public long getIdDetalle() {
		return IdDetalle;
	}


	public void setIdDetalle(long idDetalle) {
		IdDetalle = idDetalle;
	}


	public Venta getVenta() {
		return venta;
	}


	public void setVenta(Venta venta) {
		this.venta = venta;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public int getCantidad() {
		return Cantidad;
	}


	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}


	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
}
