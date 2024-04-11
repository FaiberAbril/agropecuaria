package com.jair.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jair.modelos.UnidadMedida;
import com.jair.servicios.UnidadMedidaServicios;

@Controller
@RequestMapping("/unidadMedida")
public class UnidadMedidaControlador {

	@Autowired
	private UnidadMedidaServicios medidaServicios;
	
	@GetMapping("/")
	public String paginaUnidadMedida(Model model) {
		model.addAttribute("listaUnidadesMedida",medidaServicios.ListarUnidadMedida());
		return "unidadMedida";
	}
	
	@GetMapping("/agregarUnidadMedida")
	public String NuevaUnidadMedida(Model model) {
		model.addAttribute("ObjUnidadMedida", new UnidadMedida());
		return "formularioUnidadMedida";
	}
	
	@PostMapping("/guardarunidadMedida")
	public String GuardarUnidadMedida(@ModelAttribute("ObjUnidadMedida") UnidadMedida medida) {
		medidaServicios.CrearUnidadMedida(medida);
		return "redirect:/unidadMedida/";
	}
	
	@GetMapping("/eliminarUnidadMedida/{IdUnidadesMedida}")
	public String EliminarUnidadMedida(@PathVariable("IdUnidadesMedida") Long IdUnidadesMedida) {
		medidaServicios.EliminarUnidadMedida(IdUnidadesMedida);
		return "redirect:/unidadMedida/";
	}
	
	@GetMapping("/formActualizarunidadMedida/{IdUnidadesMedida}")
	public String formActualizarUnidadMedida(Model model, @PathVariable("IdUnidadesMedida") Long IdUnidadesMedida) {
		model.addAttribute("ObjUnidadMedidaAtualizado", medidaServicios.BuscarUnidadMedida(IdUnidadesMedida));
		return "formularioActualizarUnidadMedida";
	}
	
	@PostMapping("/actualizarUnidadMedida")
	public String ActualizarUnidadMedida(@ModelAttribute("ObjUnidadMedidaAtualizado") UnidadMedida medida) {
		medidaServicios.ActualizarUnidadMedida(medida);
		return "redirect:/unidadMedida/";
	}
	
}
