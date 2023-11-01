package com.jair.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/principal")
public class PrincipalControlador {
	
	@GetMapping("/")
	public String home() {
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
