package com.jair.controladores;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jair.modelos.Detalle;
import com.jair.modelos.Producto;
import com.jair.modelos.Venta;
import com.jair.servicios.DetalleServicios;
import com.jair.servicios.ProductoServicios;
import com.jair.servicios.VentaServicios;

import jakarta.servlet.http.HttpSession;

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
	public String formDetalles(Model model, @PathVariable("IdVenta") long IdVenta, HttpSession session) {
		
		// Traigo la VentById
		Venta venta = Ventaservicios.VentaById(IdVenta);
		
		session.setAttribute("IdVenta", venta.getIdVenta());
		
		model.addAttribute("Total", venta.getTotal());
		
		// Agrego lista productos a la Vista
		model.addAttribute("listaProductos", productoServicios.ListarProducto());
		
		// Agrego lista DetallesByVenta a la Vista
		model.addAttribute("listaDetalles", detalleServicios.listByVenta(venta));
		
		// Agrego el Objeto Venta a la Vista
		model.addAttribute("ObjVenta", venta);
		
		//Agrego el Objeto Detalle a la vista
		model.addAttribute("ObjDetalle", new Detalle());
		
		return "formularioVenta";
	}
	
	/**
	@GetMapping("/formDetalle")
	public ModelAndView formGenerarVenta(HttpSession session) {
		Venta venta = (Venta)session.getAttribute("ObjVentaSession");
		ModelAndView model = new ModelAndView();
		Detalle detalle = new Detalle();
		venta.setFechaVenta(LocalDate.now());
		detalle.setVenta(venta);
		model.addObject("listaProductos", productoServicios.ListarProducto());
		model.addObject("listaDetalles", detalleServicios.listByVenta(venta));
		model.addObject("ObjDetalle", detalle);
		session.setAttribute("ObjDetalle", detalle);
		model.setViewName("formularioVenta");
		return model;
	}
	
	**/
	@PostMapping("/GenerarDetalle")
	public String GenerarDetalle(@RequestParam(value = "IdProducto") long IdProducto, @ModelAttribute("ObjDetalle") Detalle Vdetalle, HttpSession session) {
		
		long IdVenta = (long)session.getAttribute("IdVenta");
		Venta venta = Ventaservicios.VentaById(IdVenta);
		
		Detalle detalle = Vdetalle;
		Producto p = productoServicios.BuscarProducto(IdProducto);
		
		detalle.setVenta(venta);
		detalle.setProducto(p);
		
		int Cantidad = Vdetalle.getCantidad(); 

		// Validacion de Detalle
		if (p.getStockProducto() > Cantidad & p.getStockProducto() > 1) {
			
			//Asignacion de SubTotal en Detalle
			double SubTotal= Cantidad * p.getPrecioUnitario();
			detalle.setSubTotal(SubTotal);
			
			// Generación de Detalle
			detalleServicios.CrearDetalle(detalle);
			
			//Actualización Stock
			int NewStock = p.getStockProducto() - Cantidad;
			p.setStockProducto(NewStock);
			productoServicios.ActualizarProducto(p);
			
			List<Detalle> detalles = detalleServicios.listByVenta(venta);
			double Total = detalles.stream().mapToDouble(d -> d.getSubTotal()).sum();
			venta.setTotal(Total);
			System.out.print(Total);
			Ventaservicios.ActualizarVenta(venta);
			
			/**
			 * List<Detalle> detalles = detalleServicios.listByVenta(venta);
			
			double Total = 0;
			for (int i = 0; i<=detalles.size(); i++) {
				double subTotal = detalles.get(i).getSubTotal();
				Total = Total + subTotal;
				venta.setTotalVenta(Total);
			}
			
			Ventaservicios.ActualizarVenta(venta);
			
			**/
			
			return "redirect:/detalle/formDetalle/" + IdVenta;

		}

		return "ventaError";

	}
	/**
	@PostMapping("/actualizarDetalle")
	public String ActualizarDetalle(@ModelAttribute("Objdetalle") List<Detalle> detalles) {
		
		for(Detalle detalle : detalles) {
			detalleServicios.ActualizarDetalle(detalle);
			int Cantidad = detalle.getCantidad();
			long IdDetalle = detalle.getIdDetalle();

			// Actualizacion de Stock
			Producto producto = detalle.getProducto();
			producto.setStockProducto(producto.getStockProducto() - Cantidad);
			productoServicios.ActualizarProducto(producto);
		}
		return "redirect:/venta/";

	}**/
	
	@GetMapping("/cancelarVenta")
	public String CancelarCompra(HttpSession session) {
		
		long IdVenta = (long)session.getAttribute("IdVenta");
		Venta venta = Ventaservicios.VentaById(IdVenta);
		
		List<Detalle> DetallesByVenta = detalleServicios.listByVenta(venta);
		for (Detalle detalle : DetallesByVenta) {
			
			Producto p = detalle.getProducto();
			int Cantidad = detalle.getCantidad();
			int OldStock = p.getStockProducto() + Cantidad;
			p.setStockProducto(OldStock);
		
			productoServicios.ActualizarProducto(p);
			
			detalleServicios.EliminarDetalle(detalle.getIdDetalle());
			
		}
			
		Ventaservicios.DeletVentaById(IdVenta);
		
		session.invalidate();
		
		return "redirect:/venta/";
		
	}
	
	@GetMapping("/eliminarDetalle/{IdDetalle}")
	public String EliminarDetalle(@PathVariable("IdDetalle") long IdDetalle) {

		Detalle detalle = detalleServicios.DetalleById(IdDetalle);
		Venta venta = detalle.getVenta();
		Producto p = detalle.getProducto();
		int Cantidad = detalle.getCantidad();
		int OldStock = p.getStockProducto() + Cantidad;
		p.setStockProducto(OldStock);
		
		productoServicios.ActualizarProducto(p);
		detalleServicios.EliminarDetalle(IdDetalle);
		return "redirect/formDetalle/"+ venta.getIdVenta();
	}
	
}
