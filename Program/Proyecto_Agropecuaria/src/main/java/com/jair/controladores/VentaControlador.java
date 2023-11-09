package com.jair.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jair.modelos.Producto;
import com.jair.modelos.Venta;
import com.jair.servicios.ProductoServicios;
import com.jair.servicios.VentaServicios;

import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping("/venta")
public class VentaControlador {
	
	@Autowired
	private VentaServicios servicios;
	
	@Autowired
	private ProductoServicios productoServicios;
	
	@GetMapping("/")
	public String paginaVentas(Model model) {
		model.addAttribute("listaVentas",servicios.ListarVentas());
		return "ventas";
	}
	
	@GetMapping("/formVenta")
	public String formGenerarVenta(Model model, RedirectAttributes atributos) {
		model.addAttribute("ObjVenta", new Venta());
		model.addAttribute("listaProductos", productoServicios.ListarProducto());
		return "formularioVenta";
	}
	
	@PostMapping("/generarVenta")
	public String guardarVenta(@ModelAttribute("ObjVenta")Venta venta) {
		System.out.print(venta);
		int Cantidad = venta.getCantidad();
		int Stock = venta.getProductoVenta().getStockProducto();
		boolean Posibilidad= servicios.CantidadStock(Cantidad, Stock);
		if (Posibilidad==true) {
			servicios.GenerarVenta(venta);
		}
		return "redirect:/venta/";
	}

}
