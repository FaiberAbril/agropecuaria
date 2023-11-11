package com.jair.controladores;

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
		model.addAttribute("listaVentas", servicios.ListarVentas());
		return "ventas";
	}

	@GetMapping("/formVenta")
	public String formGenerarVenta(Model model, RedirectAttributes product) {
		model.addAttribute("ObjVenta", new Venta());
		model.addAttribute("listaProductos", productoServicios.ListarProducto());
		
		return "formularioVenta";
	}
	
    @GetMapping("/getProdcuto")
    public String getPrecio(@RequestParam(value = "id") Long id, RedirectAttributes Valorprecio) {
        Producto prod = productoServicios.BuscarProducto(id);
        double precio = prod.getPrecioProducto();
        Valorprecio.addFlashAttribute("PrecioCap", precio);
        return "formularioVenta" + Valorprecio;
    }

	@PostMapping("/generarVenta")
	public String guardarVenta(@ModelAttribute("ObjVenta") Venta venta) {
		
		//Captura de Variables para validación
		int Cantidad = venta.getCantidad();
		int Stock = venta.getProductoVenta().getStockProducto();
		
		//Validacion de Posibilidad de Venta
		boolean Posibilidad = servicios.CantidadStock(Cantidad, Stock);
		if (Posibilidad == true && Cantidad > 0) {
			servicios.GenerarVenta(venta);
			
				//Actualización de Stock en Producto
				int NewStock = Stock - Cantidad;
				Producto producto = venta.getProductoVenta();
				producto.setStockProducto(NewStock);
				productoServicios.ActualizarProducto(producto);
			
				//Calculo de Monto Total a Pagar
				double Precio = venta.getProductoVenta().getPrecioProducto();
				double Pago = servicios.CalcularMonto(Cantidad, Precio);
				venta.setPagoTotal(Pago);
				servicios.ActualizarVenta(venta);
				
			return "redirect:/venta/";
		} else {
			return "ventaError";
		}
	}
}
