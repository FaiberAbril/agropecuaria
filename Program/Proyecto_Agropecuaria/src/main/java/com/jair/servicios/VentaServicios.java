package com.jair.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jair.modelos.Venta;
import com.jair.repositorios.VentaRepository;

@Service
public class VentaServicios {

	private VentaRepository repository;
	
	public void GenerarVenta(Venta venta) {
		repository.save(venta);
	}
	
	public List<Venta> ListarVentas(){
		return repository.findAll();
	}
	
}
