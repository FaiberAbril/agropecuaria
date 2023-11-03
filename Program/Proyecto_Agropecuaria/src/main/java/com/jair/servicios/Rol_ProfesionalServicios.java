package com.jair.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jair.modelos.Rol_Profesional;
import com.jair.repositorios.Rol_ProfesionalRepository;

@Service
public class Rol_ProfesionalServicios {

	@Autowired
	private Rol_ProfesionalRepository profesionalRepository;
	
	public void Crearrol_Profesional(Rol_Profesional rol_profesional) {
		profesionalRepository.save(rol_profesional);
	}
	
	public void ActualizarRol_Profesional(Rol_Profesional rol_profesional) {
		profesionalRepository.save(rol_profesional);
	}
	
	public void EliminarRol_Profesional(long IdRolProfesional) {
		profesionalRepository.deleteById(IdRolProfesional);
	}
	
	public Rol_Profesional BuscarRol_Profesional(long IdRolProfesional) {
		return profesionalRepository.findById(IdRolProfesional).get();
	}
	
	public List<Rol_Profesional> ListarRol_Profesionales(){
		return profesionalRepository.findAll();
	}
	
}
