package com.jair.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jair.modelos.Detalle;
import com.jair.modelos.Venta;
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
	
	public List<Detalle> listByVenta(Venta venta){
		return detalleRepository.findByVenta(venta);
	}
	
	public void EliminarDetalle(long IdDetalle) {
		detalleRepository.deleteById(IdDetalle);
	}
	
	public long idVentabyIdDetalle(long IdDetalle) {
		return detalleRepository.getById(IdDetalle).getVenta().getIdVenta();
	}
	
}
