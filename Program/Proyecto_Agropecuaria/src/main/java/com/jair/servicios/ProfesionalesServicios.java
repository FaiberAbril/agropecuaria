package com.jair.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jair.modelos.Profesionales;
import com.jair.repositorios.ProfesionalesRepository;

@Service
public class ProfesionalesServicios {

	@Autowired
	private ProfesionalesRepository profesionalesRepository;
	
	public void AgregarProfesional(Profesionales profesional) {
		profesionalesRepository.save(profesional);
	}
	
	public void ActualizarProfesional(Profesionales profesional) {
		profesionalesRepository.save(profesional);
	}
	
	public void EliminaaProfesional(Long IdProfesionales) {
		profesionalesRepository.deleteById(IdProfesionales);
	}
	
	public Profesionales BuscarProfesionales(Long IdProfesionales) {
		return profesionalesRepository.findById(IdProfesionales).get();
	}
	
	public List<Profesionales> ListarProfesionales(){
		return profesionalesRepository.findAll();
	}
	
}
