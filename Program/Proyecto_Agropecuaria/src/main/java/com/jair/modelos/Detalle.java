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
@Table(name = "detallePedido")
public class Detalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdDetalle;
	
	@JoinColumn(nullable = true)
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Pedido pedido;
	
	@JoinColumn(nullable = true)
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Producto producto;
	
	public Detalle() {
		// TODO Auto-generated constructor stub
	}

	public Detalle(long idDetalle, Pedido pedido, Producto producto) {
		super();
		IdDetalle = idDetalle;
		this.pedido = pedido;
		this.producto = producto;
	}

	public long getIdDetalle() {
		return IdDetalle;
	}

	public void setIdDetalle(long idDetalle) {
		IdDetalle = idDetalle;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
}
