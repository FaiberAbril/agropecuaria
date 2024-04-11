package com.jair.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jair.modelos.Detalle;
import com.jair.modelos.Venta;
import com.jair.repositorios.DetalleRepository;
import com.jair.repositorios.VentaRepository;

@Service
public class VentaServicios {

	@Autowired
	private VentaRepository repository;
	
	public void GenerarVenta(Venta venta) {
		repository.save(venta);
	}
	
	public void ActualizarVenta(Venta venta) {
		repository.save(venta);
	}
	
	public List<Venta> ListarVentas(){
		return repository.findAll();
	}
	
	public Venta VentaById(long IdVenta) {
		return repository.findById(IdVenta).get();
	}
	
	public void DeletVentaById(long IdVenta) {
		repository.deleteById(IdVenta);
	}
	
}
