package com.veterinaria.backend_veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.backend_veterinaria.models.UsuarioEmpleado;

public interface UsuarioEmpleadoRepository extends JpaRepository<UsuarioEmpleado, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    
}
