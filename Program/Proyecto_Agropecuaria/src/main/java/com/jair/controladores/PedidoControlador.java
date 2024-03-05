package com.jair.controladores;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jair.modelos.Detalle;
import com.jair.modelos.Pedido;
import com.jair.modelos.Producto;
import com.jair.modelos.Venta;
//import com.jair.modelos.Venta;
import com.jair.servicios.DetalleServicios;
import com.jair.servicios.PedidoServicios;
import com.jair.servicios.ProductoServicios;
//import com.jair.servicios.VentaServicios;

@Controller
@RequestMapping("/pedido")
public class PedidoControlador {

	@Autowired
	private PedidoServicios pedidoServicios;

	@Autowired
	private ProductoServicios productoServicios;

	// @Autowired
	// private VentaServicios ventaServicios;

	@Autowired
	private DetalleServicios detalleServicios;

	@GetMapping("/GenerarPedido/{IdProducto}")
	public String formPedido(Model model, @PathVariable("IdProducto") long producto) {

		// Captura de Producto

		Producto p = productoServicios.BuscarProducto(producto);

		// Lista De Productos

		model.addAttribute("listaProductos", productoServicios.ListarProducto());
		model.addAttribute("Producto", p);

		// Validación de venta, pedido y detalle

		if (Cantidad > 0 && Cantidad < p.getStockProducto()) {

			Venta venta = new Venta();
			Detalle detalle = new Detalle();
			Pedido pedido = new Pedido();
			
			//Captura y parseo de la fecha actual
			Date dateVenta = Date.from(LocalDate.EPOCH.atStartOfDay(ZoneId.systemDefault()).toInstant());
			
			//Ingreso de valores a los modelos
			
			venta.setFechaVenta(dateVenta);
			detalle.setProducto(p);
			pedido.setVenta(venta);
			pedido.setCantidad(Cantidad);
			detalle.setPedido(pedido);

			// Actualizacion de Stock

			p.setStockProducto(p.getStockProducto() - Cantidad);

			// Inserts en la BD

			pedidoServicios.CrearPedido(pedido);
			detalleServicios.CrearDetalle(detalle);
			productoServicios.ActualizarProducto(p);

			// lista Detalles
			model.addAttribute("listaDetalles", detalleServicios.ListarDetalles());

			return "formPedido";
		} else {
			model.addAttribute("alerta", "Stock del producto: " + p.getNombreProducto() + " insuficiente");
			return "formPedido";
		}
	}
}
/*
 * @PostMapping("/guardarPedido") public String GuardarPedido() {
 * 
 * //Condicion de Validación para Venta Pedido y Detalle int Cantidad =
 * pedido.getCantidad(); int stockPro =
 * detalle.getProducto().getStockProducto();
 * 
 * if (Cantidad > 0 && Cantidad < stockPro) {
 * 
 * //Calculo Total a Pagar double Precio =
 * detalle.getProducto().getPrecioProducto(); double TPagar= Precio * Cantidad;
 * Venta venta = new Venta(); venta.setPagoTotal(TPagar);
 * ventaServicios.GenerarVenta(venta);
 * 
 * //Actualizacion de Stock Producto p = detalle.getProducto();
 * p.setStockProducto((stockPro - Cantidad));
 * productoServicios.ActualizarProducto(p);
 * 
 * //Date fecha = new Date().getTime(); //venta.setFechaVenta(fecha);
 * pedido.setVenta(venta); pedidoServicios.CrearPedido(pedido);
 * detalle.setPedido(pedido);
 * 
 * 
 * }else { return "redirect:/pedido/formPedido"; }
 * 
 * return "redirect:/pedido/formPedido"; }
 */
