package com.jair.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jair.modelos.Detalle;
import com.jair.modelos.Pedido;
import com.jair.servicios.PedidoServicios;
import com.jair.servicios.ProductoServicios;


@Controller
@RequestMapping("/pedido")
public class PedidoControlador {

	@Autowired
	private PedidoServicios pedidoServicios;
	
	@Autowired
	private ProductoServicios productoServicios;
	
	@GetMapping("/formPedido/{IdProducto}")
	public String formPedido(Model model){
		
		model.addAttribute("ObjPedido", new Pedido());
		model.addAttribute("ObjDetalle", new Detalle());
		
		return "";
	}
	
}
