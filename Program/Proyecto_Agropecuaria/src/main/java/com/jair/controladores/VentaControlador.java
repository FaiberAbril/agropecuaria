package com.jair.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jair.modelos.Venta;
import com.jair.servicios.ProductoServicios;
import com.jair.servicios.VentaServicios;

@Controller
@RequestMapping("/venta")
public class VentaControlador {
	
	@Autowired
	private VentaServicios servicios;
	
	@Autowired
	private ProductoServicios productoServicios;
	
	@GetMapping("/")
	public String paginaVentas(Model model) {
		model.addAttribute(servicios.ListarVentas());
		return "ventas";
	}
	
	@GetMapping("/formVenta")
	public String formGenerarVenta(Model model) {
		model.addAttribute("ObjVenta", new Venta());
		return "formularioVenta";
	}
	
	@PostMapping("/generarVenta")
	public String guardarVenta(@ModelAttribute("ObjVenta")Venta venta) {
		servicios.GenerarVenta(venta);
		return "redirect:/venta/";
	}

}
