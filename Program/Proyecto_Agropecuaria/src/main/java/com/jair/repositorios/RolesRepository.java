package com.jair.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jair.modelos.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long>{

}
