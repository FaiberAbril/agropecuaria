package com.jair.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jair.modelos.Pedido;
import com.jair.modelos.Venta;
import com.jair.repositorios.PedidoRepository;

@Service
public class PedidoServicios {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public void CrearPedido(Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
	public List<Pedido> BuscarPedidoVenta(Venta venta) {
		return pedidoRepository.findByVenta(venta);
	}
	
	public Pedido findPedido(long IdPedido){
		return (Pedido) pedidoRepository.findById(IdPedido);
	}
	
	public void ActualizarPedido(Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
	public List<Pedido> ListarPedidos(){
		return pedidoRepository.findAll();
	}
	
}
