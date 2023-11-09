package com.jair.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jair.modelos.Venta;
import com.jair.repositorios.VentaRepository;

@Service
public class VentaServicios {

	@Autowired
	private VentaRepository repository;
	
	public void GenerarVenta(Venta venta) {
		repository.save(venta);
	}
	
	public List<Venta> ListarVentas(){
		return repository.findAll();
	}
	
	public String IdProducto(long IdVenta) {
		return repository.findById(IdVenta).get().getProductoVenta().getNombreProducto();
	}
	
	public boolean CantidadStock(int Cantidad, int Stock) {
		if (Cantidad<Stock) {
			return true;
		}
		return false;
	}
	
}
