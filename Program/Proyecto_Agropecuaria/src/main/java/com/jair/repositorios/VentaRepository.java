package com.jair.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jair.modelos.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{
	
}
