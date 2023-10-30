package com.jair.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jair.modelos.UnidadMedida;
import com.jair.repositorios.UnidadMedidaRepository;

@Service
public class UnidadMedidaServicios {

	@Autowired
	private UnidadMedidaRepository unidadRepository;
	
	public void CrearUnidadMedida(UnidadMedida unidad) {
		unidadRepository.save(unidad);
	}
	
	public void ActualizarUnidadMedida(UnidadMedida unidad) {
		unidadRepository.save(unidad);
	}
	
	public void EliminarUnidadMedida(Long IdUnidadesMedida) {
		unidadRepository.deleteById(IdUnidadesMedida);
	}
	
	public UnidadMedida BuscarUnidadMedida(Long IdUnidadesMedida) {
		return unidadRepository.findById(IdUnidadesMedida).get();
	}
	
	public List<UnidadMedida> ListarUnidadMedida(){
		return unidadRepository.findAll();
	}
	
}
