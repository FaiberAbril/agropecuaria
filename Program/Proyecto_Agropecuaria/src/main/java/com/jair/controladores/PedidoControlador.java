package com.jair.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jair.modelos.Detalle;
import com.jair.modelos.Pedido;
import com.jair.modelos.Producto;
import com.jair.servicios.PedidoServicios;
import com.jair.servicios.ProductoServicios;

import jakarta.websocket.server.PathParam;


@Controller
@RequestMapping("/pedido")
public class PedidoControlador {

	@Autowired
	private PedidoServicios pedidoServicios;
	
	@Autowired
	private ProductoServicios productoServicios;
	
	@GetMapping("/formPedido/{IdProducto}")
	public String formPedido(Model model, @PathVariable("IdProducto") long producto){
		model.addAttribute("ObjPedido", new Pedido());
		model.addAttribute("ObjDetalle", new Detalle());
		Producto p = productoServicios.BuscarProducto(producto);
		model.addAttribute("ObjProducto", p);
		
		return "formPedido";
	}
	
}
