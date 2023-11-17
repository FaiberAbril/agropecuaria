package com.jair.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView FormPedido(@PathVariable("IdProducto") long IdProducto) {
		ModelAndView modelandview = new ModelAndView();
		Pedido pedido = new Pedido();
		modelandview.addObject("ObjPedido", pedido);
		pedidoServicios.CrearPedido(pedido);
		modelandview.addObject("ProductoPedido", productoServicios.BuscarProducto(IdProducto));
		pedido.setProdcuto(productoServicios.BuscarProducto(IdProducto));
		pedidoServicios.ActualizarPedido(pedido);
		return modelandview;
	}
	
}
