package com.jair.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jair.modelos.Pedido;
import com.jair.repositorios.PedidoRepository;

@Service
public class PedidoServicios {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public void CrearPedido(Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
	public void ActualizarPedido(Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
	public void EliminarPedido(long IdPedido) {
		pedidoRepository.deleteById(IdPedido);
	}
	
	public List<Pedido> ListarPedidos(){
		return pedidoRepository.findAll();
	}
	
	public Pedido BuscarPedido(long IdPedido) {
		return pedidoRepository.getById(IdPedido);
	}
	
}
