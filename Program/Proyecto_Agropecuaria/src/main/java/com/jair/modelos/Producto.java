package com.jair.modelos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name= "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdProducto;

	@Column(length = 50, nullable = false)
	private String nombreProducto;
	
	@Column(length = 50, nullable = false)
	private String descripcionProducto;
	
	@Column(scale = 2, nullable = false)
	private double precioProducto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="categoria")
	private CategoriaProducto categoriaProdProducto;
	
	@Column()
	private int stockProducto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="unidadDeMedida")
	private UnidadMedida unidadMedidaProducto;
	
	@Column()
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fechaRegistroProdcuto;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(long idProducto, String nombreProducto, String descripcionProducto, double precioProducto,
			CategoriaProducto categoriaProdProducto, int stockProducto, UnidadMedida unidadMedidaProducto,
			Date fechaRegistroProdcuto) {
		super();
		IdProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.precioProducto = precioProducto;
		this.categoriaProdProducto = categoriaProdProducto;
		this.stockProducto = stockProducto;
		this.unidadMedidaProducto = unidadMedidaProducto;
		this.fechaRegistroProdcuto = fechaRegistroProdcuto;
	}

	public long getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(long idProducto) {
		IdProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public CategoriaProducto getCategoriaProdProducto() {
		return categoriaProdProducto;
	}

	public void setCategoriaProdProducto(CategoriaProducto categoriaProdProducto) {
		this.categoriaProdProducto = categoriaProdProducto;
	}

	public int getStockProducto() {
		return stockProducto;
	}

	public void setStockProducto(int stockProducto) {
		this.stockProducto = stockProducto;
	}

	public UnidadMedida getUnidadMedidaProducto() {
		return unidadMedidaProducto;
	}

	public void setUnidadMedidaProducto(UnidadMedida unidadMedidaProducto) {
		this.unidadMedidaProducto = unidadMedidaProducto;
	}

	public Date getFechaRegistroProdcuto() {
		return fechaRegistroProdcuto;
	}

	public void setFechaRegistroProdcuto(Date fechaRegistroProdcuto) {
		this.fechaRegistroProdcuto = fechaRegistroProdcuto;
	}
	
}
