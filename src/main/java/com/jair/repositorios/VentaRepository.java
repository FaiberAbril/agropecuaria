package com.jair.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jair.modelos.Detalle;
import com.jair.modelos.Venta;
import java.util.List;


@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{
	
}
