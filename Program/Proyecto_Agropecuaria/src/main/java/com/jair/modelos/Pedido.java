package com.jair.modelos;

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

@Entity
@Table(name="pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdPedido;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(nullable = true)
	private Venta venta;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private Detalle detalle;
	
	@Column(nullable = false)
	private int Cantidad;
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	public Pedido(long idPedido, Venta venta, Detalle detalle, int cantidad) {
		super();
		IdPedido = idPedido;
		this.venta = venta;
		this.detalle = detalle;
		Cantidad = cantidad;
	}

	public long getIdPedido() {
		return IdPedido;
	}

	public void setIdPedido(long idPedido) {
		IdPedido = idPedido;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	
	
}
