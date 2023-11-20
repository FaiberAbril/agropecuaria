package com.jair.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jair.modelos.Pedido;
import com.jair.modelos.Venta;
import com.jair.repositorios.PedidoRepository;
import com.jair.repositorios.VentaRepository;

@Service
public class VentaServicios {

	@Autowired
	private VentaRepository repository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido GenerarVenta(Venta venta) {
		repository.save(venta);
		Pedido p = new Pedido();
		p.setVenta(venta);
		pedidoRepository.save(p);
		return p;
	}
	
	public void ActualizarVenta(Venta venta) {
		repository.save(venta);
	}
	
	public List<Venta> ListarVentas(){
		return repository.findAll();
	}
	
	/*
	public String IdProducto(long IdVenta) {
		return repository.findById(IdVenta).get().getProductoVenta().getNombreProducto();
	}
	
	public boolean CantidadStock(int Cantidad, int Stock) {
		if (Cantidad<Stock) {
			return true;
		}
		return false;
	}
	
	public double CalcularMonto(int Cantidad, double Precio) {
		double TotalPago = Cantidad * Precio;
		return TotalPago;
	}
	*/
	
	
	
}
