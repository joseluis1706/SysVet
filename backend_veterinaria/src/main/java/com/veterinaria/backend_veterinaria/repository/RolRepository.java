package com.veterinaria.backend_veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.backend_veterinaria.models.Rol;


public interface RolRepository extends JpaRepository<Rol, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    
}
