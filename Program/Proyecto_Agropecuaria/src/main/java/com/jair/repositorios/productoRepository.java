package com.jair.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jair.modelos.Producto;

@Repository
public interface productoRepository extends JpaRepository<Producto, Long>{

}
