package com.jair.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jair.modelos.Profesionales;

@Repository
public interface ProfesionalesRepository extends JpaRepository<Profesionales, Long>{

}
