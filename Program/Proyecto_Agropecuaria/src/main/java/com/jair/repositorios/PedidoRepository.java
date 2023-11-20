package com.jair.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jair.modelos.Pedido;
import com.jair.modelos.Venta;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	List<Pedido> findById(long IdPedido);
	List<Pedido> findByVenta(Venta venta);
}
