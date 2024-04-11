package com.jair.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jair.modelos.Cliente;
import com.jair.servicios.ClienteServicios;

@Controller
@RequestMapping("/cliente")
public class ClienteControlador {

	@Autowired
	private ClienteServicios clienteServicios;
	
	@GetMapping("/")
	public String PaginaClientes(Model model) {
		model.addAttribute("listaClientes", clienteServicios.ListarClientes());
		return "clientes";
	}
	
	@GetMapping("/agregarCliente")
	public String AgregarCliente(Model model) {
		model.addAttribute("ObjCliente", new Cliente());
		return "formularioAgregarCliente";
	}
	
	@PostMapping("/guardarCliente")
	public String GuardarCliente(@ModelAttribute("ObjCliente") Cliente cliente) {
		clienteServicios.CrearCliente(cliente);
		return "redirect:/cliente/";
	}
	
	@GetMapping("/eliminarCliente/{idCliente}")
	public String EliminarCliente(@PathVariable("idCliente") Long idCliente) {
		clienteServicios.EliminarCliente(idCliente);
		return "redirect:/cliente/";
	}
	
	@GetMapping("/formActuActualizarCliente/{idCliente}")
	public String formularioActualizarCliente(Model model, @PathVariable("idCliente") Long idCliente) {
		model.addAttribute("ObjCliente", clienteServicios.BuscarCliente(idCliente));
		return "formularioActualizarCliente";
	}
	
	@PostMapping("/actualizarCliente")
	public String ActualizarCliente(@ModelAttribute("ObjCliente") Cliente cliente) {
		clienteServicios.ActualizarCliente(cliente);
		return "redirect:/cliente/";
	}
	
}
