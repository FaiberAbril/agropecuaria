package com.jair.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jair.modelos.Producto;
import com.jair.servicios.ProductoServicios;

@Controller
@RequestMapping("/producto")
public class ProductoControlador {

	@Autowired
	private ProductoServicios productoServicios;
	
	@GetMapping("/")
	public String paginaProductos(Model model) {
		model.addAttribute(productoServicios.ListarProducto());
		return "productos";
	}
	
	@GetMapping("/agregarProducto")
	public String NuevoProducto(Model model) {
		model.addAttribute("ObjProducto", new Producto());
		return "/formularioAgregarProducto";
	}
	
	@PostMapping("/guardarProducto")
	public String GuardarProducto(@ModelAttribute("ObjProducto") Producto producto) {
		productoServicios.CrearProducto(producto);
		return "redirect:/producto/";
	}
	
	@GetMapping("/eliminarProducto/{IdProducto}")
	public String EliminarProducto(@PathVariable("IdProducto") Long IdProducto) {
		productoServicios.EliminarProducto(IdProducto);
		return "redirect:/producto/";
	}
	
	@GetMapping("/formActualizarProducto/{IdProducto}")
	public String FormulairoActualizarProducto(Model model, @PathVariable("IdProducto") Long IdProducto) {
		model.addAttribute("ObjProductoActualizado", productoServicios.BuscarProducto(IdProducto));
		return "formularioActualizarProducto";
	}
	
	@PostMapping("/actualizarProducto")
	public String ActualizarProducto(@ModelAttribute("ObjProductoActualizado") Producto producto) {
		productoServicios.ActualizarProducto(producto);
		return "redirect:/producto/";
	}
	
}
