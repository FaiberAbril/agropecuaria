package com.jair.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jair.modelos.Roles;
import com.jair.servicios.RolesServicios;

import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping("/rol")
public class RolControlador {

	@Autowired
	private RolesServicios rolesServicios;
	
	@GetMapping("/")
	public String PaginaRol(Model model) {
		model.addAttribute("listRoles", rolesServicios.ListarRoles());
		return "roles";
	}
	
	@GetMapping("/agregarRol")
	public String AgregarRol(Model model) {
		model.addAttribute("ObjRol", new Roles());
		return "formularioRol";
	}
	
	@PostMapping("/guardarRol")
	public String GuardarRol(@ModelAttribute("ObjRol") Roles roles) {
		rolesServicios.CrearRol(roles);
		return "redirect:/rol/";
	}
	
	@GetMapping("/eliminarRol/{IdRol}")
	public String EliminarRol(@PathVariable("IdRol") long IdRol) {
		rolesServicios.EliminarRol(IdRol);
		return "redirect:/rol/";
	}
	
	@GetMapping("/formActualziarRol/{IdRol}")
	public String FormuliarioActualizarRol(Model model, @PathVariable("IdRol") long IdRol) {
		model.addAttribute("ObjRolActualizado", rolesServicios.BuscarRol(IdRol));
		return "formularioActualizarRol";
	}
	
	@PostMapping("/actualziarRol")
	public String ActualizarRol(@ModelAttribute("ObjRolActualizado")Roles roles) {
		rolesServicios.ActualizarRol(roles);
		return "redirect:/rol/";
	}
	
}
