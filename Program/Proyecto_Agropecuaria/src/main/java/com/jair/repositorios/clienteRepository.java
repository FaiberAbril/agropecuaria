package com.jair.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jair.modelos.Cliente;

@Repository
public interface clienteRepository extends JpaRepository<Cliente, Long>{

}
