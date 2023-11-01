package com.jair.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jair.modelos.CategoriaProducto;
import com.jair.servicios.CategoriaProductoServicios;

@Controller
@RequestMapping("/categoria")
public class CategoriaProductoControlador {
	
	@Autowired
	private CategoriaProductoServicios categoriaServicios;
	
	@GetMapping("/")
	public String PaginaCategorias(Model model) {
		model.addAttribute("listaCategoria",categoriaServicios.ListarCategoria());
		return "categoria";
	}
	
	@GetMapping("/agregarCategoria")
	public String NuevaCategoria (Model model) {
		model.addAttribute("ObjCategoria", new CategoriaProducto());
		return "formularioCategoria";
	}
	
	@PostMapping("/guardarCategoria")
	public String GuardarCategoria(@ModelAttribute("ObjCategoria") CategoriaProducto categoria) {
		categoriaServicios.CrearCategoria(categoria);
		return "redirect:/categoria/";
	}
	
	@GetMapping("/eliminarCategoria/{IdCategoriaProdcuto}")
	public String EliminarCategoria(@PathVariable("IdCategoriaProdcuto") Long IdCategoriaProdcuto) {
		categoriaServicios.EliminarCategoria(IdCategoriaProdcuto);
		return "redirect:/categoria/";
	}
	
	@GetMapping("/formActualizarCategoria/{IdCategoriaProdcuto}")
	public String FormActualizarCategoria(Model model, @PathVariable("IdCategoriaProdcuto") Long IdCategoriaProdcuto) {
		model.addAttribute("ObjCategoriaActualizado", categoriaServicios.BuscarCategoria(IdCategoriaProdcuto));
		return "formularioActualizarCategoria";
	}
	
	@PostMapping("/actualizarCategoria")
	public String ActualizarCategoria(@ModelAttribute("ObjCategoriaActualizado") CategoriaProducto categoria) {
		categoriaServicios.ActualizarCategoria(categoria);
		return "redirect:/categoria/";
	}
	
}
