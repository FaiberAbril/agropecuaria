package com.jair.controladores;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jair.modelos.Producto;
import com.jair.modelos.Venta;
import com.jair.modelos.Detalle;
import com.jair.servicios.DetalleServicios;
import com.jair.servicios.ProductoServicios;
import com.jair.servicios.VentaServicios;

import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping("/venta")
public class VentaControlador {

	@Autowired
	private DetalleServicios detalleServicios;

	@Autowired
	private VentaServicios Ventaservicios;

	@Autowired
	private ProductoServicios productoServicios;
	
	Venta venta = new Venta();

	
	@GetMapping("/formVenta")
	public String formGenerarVenta(Model model) {
		venta.setFechaVenta(LocalDate.now());
		Ventaservicios.GenerarVenta(venta);	
		model.addAttribute("listaProductos", productoServicios.ListarProducto());
		model.addAttribute("listaDetalles", detalleServicios.listByVenta(venta));
		return "formularioVenta";
	}

	public String GenerarDetalle(@PathVariable("IdProducto") long IdProducto) {
		
		Detalle detalle = new Detalle();
		Producto p = productoServicios.BuscarProducto(IdProducto);
		
		detalle.setProducto(p);
		detalle.setCantidad(1);
		detalle.setVenta(venta);
		
		//Validacion de Venta
		if(p.getStockProducto() > detalle.getCantidad()) {
			Ventaservicios.GenerarVenta(venta);
			detalleServicios.CrearDetalle(detalle);
			
			return "redirect:/detalle/formDetalle" + venta.getIdVenta();
			
		}
		
		return "ventaError";
		
	}
	
	

	/*
	 * @PostMapping("/generarVenta") public String
	 * guardarVenta(@ModelAttribute("ObjVenta") Venta venta) {
	 * 
	 * //Captura de Variables para validación int Cantidad = venta.getCantidad();
	 * int Stock = venta.getProductoVenta().getStockProducto();
	 * 
	 * //Validacion de Posibilidad de Venta boolean Posibilidad =
	 * servicios.CantidadStock(Cantidad, Stock); if (Posibilidad == true && Cantidad
	 * > 0) { servicios.GenerarVenta(venta);
	 * 
	 * //Actualización de Stock en Producto int NewStock = Stock - Cantidad;
	 * Producto producto = venta.getProductoVenta();
	 * producto.setStockProducto(NewStock);
	 * productoServicios.ActualizarProducto(producto);
	 * 
	 * //Calculo de Monto Total a Pagar double Precio =
	 * venta.getProductoVenta().getPrecioProducto(); double Pago =
	 * servicios.CalcularMonto(Cantidad, Precio); venta.setPagoTotal(Pago);
	 * servicios.ActualizarVenta(venta);
	 * 
	 * return "redirect:/venta/"; } else { return "ventaError"; } }
	 */
}
