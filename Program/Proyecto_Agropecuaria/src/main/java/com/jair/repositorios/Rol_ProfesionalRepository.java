package com.jair.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jair.modelos.Rol_Profesional;

@Repository
public interface Rol_ProfesionalRepository extends JpaRepository<Rol_Profesional, Long>{

}
