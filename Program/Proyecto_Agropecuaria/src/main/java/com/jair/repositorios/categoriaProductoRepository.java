package com.jair.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jair.modelos.CategoriaProducto;

@Repository
public interface categoriaProductoRepository extends JpaRepository<CategoriaProducto, Long>{

}
