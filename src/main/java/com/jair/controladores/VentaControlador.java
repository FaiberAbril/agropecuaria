package com.jair.controladores;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jair.modelos.Detalle;
import com.jair.modelos.Venta;
import com.jair.servicios.DetalleServicios;
import com.jair.servicios.ProductoServicios;
import com.jair.servicios.VentaServicios;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/venta")
public class VentaControlador {

	@Autowired
	private DetalleServicios detalleServicios;

	@Autowired
	private VentaServicios Ventaservicios;

	@Autowired
	private ProductoServicios productoServicios;

	
	@GetMapping("/")
	public String paginaVentas(Model model) {
		model.addAttribute("listaVentas", detalleServicios.listarDetalles());
		return "ventas";
	}
	/**
	@GetMapping("/generarVenta")
	public String NewVenta(Model model) {
		Venta venta = new Venta();
		model.addAttribute("ObjVenta", venta);
		venta.setFechaVenta(LocalDate.now());
		long IdVenta = venta.getIdVenta();
		return "redirect:/detalle/formDetalle";
	}**/
	
	@GetMapping("/generarVenta")
	public String NewVenta() {
		Venta venta = new Venta();
		venta.setFechaVenta(LocalDate.now());
		Ventaservicios.GenerarVenta(venta);
		long id = venta.getIdVenta();
		return "redirect:/detalle/formDetalle/" + id;
	}
	
	/**
	@GetMapping("/generarVenta")
	public ModelAndView NewVenta() {
		ModelAndView model = new ModelAndView();
		Venta venta = new Venta();
		venta.setFechaVenta(LocalDate.now());
		model.addObject("ObjVenta", venta);
		model.setViewName("redirect:/detalle/formDetalle");
		return model;
	}**/

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
