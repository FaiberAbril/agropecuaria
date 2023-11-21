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
import com.jair.modelos.Venta;
import com.jair.servicios.PedidoServicios;
import com.jair.servicios.ProductoServicios;
import com.jair.servicios.VentaServicios;

import jakarta.websocket.server.PathParam;


@Controller
@RequestMapping("/pedido")
public class PedidoControlador {

	@Autowired
	private PedidoServicios pedidoServicios;
	
	@Autowired
	private ProductoServicios productoServicios;
	
	private VentaServicios ventaServicios;
	
	@GetMapping("/formPedido/{IdProducto}")
	public String formPedido(Model model, @PathVariable("IdProducto") long producto, @ModelAttribute("ObjPedido") Pedido pedido, @ModelAttribute("ObjVenta") Venta venta){
		Producto p = productoServicios.BuscarProducto(producto);
		ventaServicios.GenerarVenta(venta);
		pedido.setVenta(venta);
		pedidoServicios.CrearPedido(pedido);
		model.addAttribute("ObjProducto", p);
		Detalle detalle = new Detalle();
		detalle.setPedido(pedido);
		detalle.setProducto(p);
		return "formPedido";
	}
	
}
