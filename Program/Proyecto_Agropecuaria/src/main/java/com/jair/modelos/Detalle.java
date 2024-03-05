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
	private Producto producto;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn()
	private Venta venta;
	
	@Column
	private int Cantidad;

	public Detalle() {
		// TODO Auto-generated constructor stub
	}

	public Detalle(long idDetalle, Producto producto, Venta venta, int cantidad) {
		super();
		IdDetalle = idDetalle;
		this.producto = producto;
		this.venta = venta;
		Cantidad = cantidad;
	}

	public long getIdDetalle() {
		return IdDetalle;
	}

	public void setIdDetalle(long idDetalle) {
		IdDetalle = idDetalle;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	
}
