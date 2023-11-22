package com.jair.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jair.modelos.Detalle;
import com.jair.modelos.Pedido;
import com.jair.modelos.Producto;
import com.jair.modelos.Venta;
import com.jair.servicios.DetalleServicios;
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
	
	@Autowired
	private VentaServicios ventaServicios;
	
	@Autowired
	private DetalleServicios detalleServicios;
	
	@GetMapping("/GenerarPedido/{IdProducto}")
	public String formPedido(Model model, @PathVariable("IdProducto") long producto){
		Producto p = productoServicios.BuscarProducto(producto);
		model.addAttribute("Producto", p);
		model.addAttribute("ObjPedido", new Pedido());
		model.addAttribute("ObjVenta", new Venta());
		model.addAttribute("listaDetalles", detalleServicios.ListarDetalles());
		return "formPedido";
	}
	
	@PostMapping("/guardarPedido")
	public String GuardarPedido(@ModelAttribute("ObjPedido") Pedido pedido, @ModelAttribute("ObjVenta") Venta venta, @ModelAttribute("Producto") Producto p) {
		
		//Condicion de Validación para Venta Pedido y Detalle
				int Cantidad = pedido.getCantidad();
				int stockPro = p.getStockProducto();
				
				if (Cantidad > 0 && Cantidad < stockPro) {
					
					ventaServicios.GenerarVenta(venta);
					pedido.setVenta(venta);
					pedidoServicios.CrearPedido(pedido);
					Detalle detalle = new Detalle();
					detalle.setPedido(pedido);
					detalle.setProducto(p);
					
				}else {
					return "redirect:/pedido/formPedido";
				}
		
		return "";
	}
	
}
