package com.jair.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jair.modelos.Roles;
import com.jair.repositorios.RolesRepository;

@Service
public class RolesServicios {

	@Autowired
	private RolesRepository repository;
	
	public void CrearRol(Roles roles) {
		repository.save(roles);
	}
	
	public void ActualizarRol(Roles roles) {
		repository.save(roles);
	}
	
	public void EliminarRol(long IdRol) {
		repository.deleteById(IdRol);
	}
	
	public Roles BuscarRol(long IdRol) {
		return repository.findById(IdRol).get();
	}
	
	public List<Roles> ListarRoles(){
		return repository.findAll();
	}
	
}
