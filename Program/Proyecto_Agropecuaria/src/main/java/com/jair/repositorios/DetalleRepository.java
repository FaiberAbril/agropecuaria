package com.jair.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jair.modelos.Detalle;
import com.jair.modelos.Pedido;
import com.jair.modelos.Producto;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle, Long>{
	List<Detalle> findByProducto(Producto producto);
	List<Detalle> findByPedido(Pedido pedido);
}
