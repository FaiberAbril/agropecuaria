package com.jair.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/principal")
public class PrincipalControlador {
	
	@Autowired
	private ProductoControlador controlador;
	
	@GetMapping("/")
	public String home(Model model) {
		
		
		return "Principal";
	}
	
	@GetMapping("/productos")
	public String Productos() {
		return "redirect:/producto/";
	}
	
	@GetMapping("/clientes")
	public String Clientes() {
		return "redirect:/cliente/";
	}
	
}
