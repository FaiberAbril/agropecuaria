package com.jair.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jair.modelos.Detalle;
import com.jair.modelos.Pedido;
import com.jair.repositorios.DetalleRepository;

@Service
public class DetalleServicios {
	
	@Autowired
	private DetalleRepository detalleRepository;
	
	public void CrearDetalle(Detalle detalle) {
		detalleRepository.save(detalle);
	}
	
	public void ActualizarDetalle(Detalle detalle) {
		detalleRepository.save(detalle);
	}
	
	public List<Detalle> ListarDetalles(){
		return detalleRepository.findAll();
	}
	
	public List<Detalle> ListByPedido(Pedido pedido){
		return detalleRepository.findByPedido(pedido);
	}
	
	public List<Detalle> ListaDetalles(){
		return detalleRepository.findAll();
	}
	
}
