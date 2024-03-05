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
	public String formGenerarVenta(Model model, @PathVariable("IdVenta") long IdVenta) {
		Venta venta = Ventaservicios.VentaById(IdVenta);
		venta.setIdVenta(IdVenta);
		System.out.println(venta.getIdVenta());
		//Ventaservicios.ActualizarVenta(venta);
		model.addAttribute("listaProductos", productoServicios.ListarProducto());
		model.addAttribute("listaDetalles", detalleServicios.listByVenta(venta));
		model.addAttribute("venta", venta);
		return "formularioVenta";
	}
	
	@GetMapping("/GenerarDetalle/{IdProducto}/{IdVenta}")
	public String GenerarDetalle(@PathVariable("IdProducto") long IdProducto, @PathVariable("IdVenta")long IdVenta) {
		Venta venta = Ventaservicios.VentaById(IdVenta);
		Detalle detalle = new Detalle();
		Producto p = productoServicios.BuscarProducto(IdProducto);
		
		detalle.setProducto(p);
		detalle.setCantidad(1);
		detalle.setVenta(venta);
		
		//Validacion de Venta
		if(p.getStockProducto() > detalle.getCantidad()) {
			
			//Generación de Detalle
			detalleServicios.CrearDetalle(detalle);
			long id = venta.getIdVenta();
			
			return "redirect:/detalle/formDetalle/" + id;
			
		}
		
		return "ventaError";
		
	}

	
	public String ActualizarDetalle(@PathVariable("Cantidad") int Cantidad, @ModelAttribute("Detalle") Detalle detalle) {

		detalle.setCantidad(Cantidad);
		detalleServicios.ActualizarDetalle(detalle);

		// Actualizacion de Stock
		Producto producto = detalle.getProducto();
		producto.setStockProducto(producto.getStockProducto() - Cantidad);
		productoServicios.ActualizarProducto(producto);
		
		return "redirect:/detalle/formDetalle/" + detalle.getVenta().getIdVenta();

	}
	
	@GetMapping("/eliminarDetalle/{IdDetalle}")
	public String EliminarDetalle(@PathVariable("IdDetalle")long IdDetalle) {
		//Captura de IdVenta
		long Id = detalleServicios.idVentabyIdDetalle(IdDetalle);
		detalleServicios.EliminarDetalle(IdDetalle);
		return "redirect:/detalle/formDetalle/" + Id;
	}

}
