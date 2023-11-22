package com.jair.controladores;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		model.addAttribute("listaProductos", productoServicios.ListarProducto());
		model.addAttribute("Producto", p);
		model.addAttribute("ObjPedido", new Pedido());
		model.addAttribute("listaDetalles", detalleServicios.ListarDetalles());
		return "formPedido";
	}
	
	@PostMapping("/guardarPedido")
	public String GuardarPedido(@ModelAttribute("ObjPedido") Pedido pedido, @ModelAttribute("p") Producto p) {
		
		//Condicion de Validación para Venta Pedido y Detalle
				int Cantidad = pedido.getCantidad();
				int stockPro = p.getStockProducto();
				
				if (Cantidad > 0 && Cantidad < stockPro) {
					
					//Calculo Total a Pagar
					double Precio = p.getPrecioProducto();
					double TPagar= Precio * Cantidad;
					Venta venta = new Venta();
					venta.setPagoTotal(TPagar);
					ventaServicios.GenerarVenta(venta);
					
					//Actualizacion de Stock
					p.setStockProducto(stockPro - Cantidad);
					productoServicios.ActualizarProducto(p);
					
					//Date fecha = new Date().getTime();
					//venta.setFechaVenta(fecha);
					pedido.setVenta(venta);
					pedidoServicios.CrearPedido(pedido);
					Detalle detalle = new Detalle();
					detalle.setPedido(pedido);
					detalle.setProducto(p);
					
				}else {
					return "redirect:/pedido/formPedido";
				}
		
		return "redirect:/pedido/formPedido";
	}
	
}
