package com.jair.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jair.modelos.Profesionales;
import com.jair.servicios.ProfesionalesServicios;
import com.jair.servicios.RolesServicios;

@Controller
@RequestMapping("/profesional")
public class ProfesionalControlador {

	@Autowired
	private ProfesionalesServicios profesionalesServicios;
	
	@Autowired
	private RolesServicios rolesServicios;
	
	@GetMapping("/")
	public String PaginaProfesionales(Model model) {
		model.addAttribute("listaProfesionales", profesionalesServicios.ListarProfesionales());
		//model.addAttribute("listaProfesionales", rol_ProfesionalServicios.ListarRol_Profesionales());
		return "Profecionales";
	}
	
	@GetMapping("/agregarProfesional")
	public String AgregarProfesional(Model model) {
		model.addAttribute("ObjProfesional", new Profesionales());
		model.addAttribute("listaRoles", rolesServicios.ListarRoles());
		return "formularioAgregarProfesionales";
	}
	
	@PostMapping("/guardarProfesional")
	public String GuardarProfesional(@ModelAttribute("ObjProfesional") Profesionales profesionales) {
		profesionalesServicios.AgregarProfesional(profesionales);
		
		return "redirect:/profesional/";
	}
	
	@GetMapping("/eliminarProfesional/{IdProfesionales}")
	public String EliminarProfesional(@PathVariable("IdProfesionales") long IdProfesionales) {
		profesionalesServicios.EliminaaProfesional(IdProfesionales);
		return "redirect:/profesional/";
	}
	
	@GetMapping("/formActualizarProfesional/{IdProfesionales}")
	public String FormularioActualizarProfesional(Model model, @PathVariable("IdProfesionales") long IdProfesionales) {
		model.addAttribute("ObjProfesionalActualizado",profesionalesServicios.BuscarProfesionales(IdProfesionales));
		model.addAttribute("listaRoles", rolesServicios.ListarRoles());
		return "formularioActualizarProfesional";
	}
	
	@PostMapping("/actualizarProfesional")
	public String ActualizarProfesional(@ModelAttribute("ObjProfesionalActualizado") Profesionales profesionales) {
		profesionalesServicios.ActualizarProfesional(profesionales);
		return "redirect:/profesional/";
	}
	
}
