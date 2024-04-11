package com.jair.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="categoriasproductos")
public class CategoriaProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdCategoriaProdcuto;
	
	@Column(length = 50)
	private String Categoria;
	
	@Column(length = 50)
	private String descripcionCategoria;
	
	public CategoriaProducto() {
		// TODO Auto-generated constructor stub
	}

	public CategoriaProducto(long idCategoriaProdcuto, String categoria, String descripcionCategoria) {
		super();
		IdCategoriaProdcuto = idCategoriaProdcuto;
		Categoria = categoria;
		this.descripcionCategoria = descripcionCategoria;
	}

	public long getIdCategoriaProdcuto() {
		return IdCategoriaProdcuto;
	}

	public void setIdCategoriaProdcuto(long idCategoriaProdcuto) {
		IdCategoriaProdcuto = idCategoriaProdcuto;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

	public String getDescripcionCategoria() {
		return descripcionCategoria;
	}

	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}
	
}
