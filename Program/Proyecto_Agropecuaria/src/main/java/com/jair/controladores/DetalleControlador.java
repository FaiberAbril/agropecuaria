package com.jair.controladores;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jair.modelos.Detalle;
import com.jair.modelos.Producto;
import com.jair.modelos.Venta;
import com.jair.servicios.DetalleServicios;
import com.jair.servicios.ProductoServicios;
import com.jair.servicios.VentaServicios;

@Controller
@RequestMapping("/detalle")
public class DetalleControlador {

	@Autowired
	private DetalleServicios detalleServicios;

	@Autowired
	private VentaServicios Ventaservicios;

	@Autowired
	private ProductoServicios productoServicios;

	@GetMapping("/formDetalle/{IdVenta}")
	public String formGenerarVenta(Model model, @ModelAttribute("IdVenta") long IdVenta) {
		Venta venta = Ventaservicios.VentaById(IdVenta);
		model.addAttribute("listaProductos", productoServicios.ListarProducto());
		model.addAttribute("listaDetalles", detalleServicios.listByVenta(venta));
		return "formularioVenta";
	}

	
	public void ActualizarDetalle(@PathVariable("Cantidad") int Cantidad, @ModelAttribute("Detalle") Detalle detalle) {

		detalle.setCantidad(Cantidad);
		detalleServicios.ActualizarDetalle(detalle);

		// Actualizacion de Stock
		Producto producto = detalle.getProducto();
		producto.setStockProducto(producto.getStockProducto() - Cantidad);
		productoServicios.ActualizarProducto(producto);

	}

}
