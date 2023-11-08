package com.jair.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jair.modelos.Producto;
import com.jair.repositorios.productoRepository;

@Service
public class ProductoServicios {

	@Autowired
	private productoRepository productoRepository;

	public void CrearProducto(Producto producto) {
		productoRepository.save(producto);
	}

	public void ActualizarProducto(Producto producto) {
		productoRepository.save(producto);
	}

	public void EliminarProducto(Long IdProdcuto) {
		productoRepository.deleteById(IdProdcuto);
	}

	public Producto BuscarProducto(Long IdProdcuto) {
		return productoRepository.findById(IdProdcuto).get();
	}

	public List<Producto> ListarProducto() {
		return productoRepository.findAll();

	}

	public  double TotalPrecio() {
		return productoRepository.findAll().stream().mapToDouble(Producto -> Producto.getPrecioProducto()).sum();
	}

	public double TotalStock() {
		return productoRepository.findAll().stream().mapToDouble(Producto -> Producto.getStockProducto()).sum();
	}

	public double TotalInventario() {
		double totalPrecio = TotalPrecio();
		double tolalStock = TotalStock();
		double totalInventario = tolalStock * totalPrecio;
		return totalInventario;
	}

}
