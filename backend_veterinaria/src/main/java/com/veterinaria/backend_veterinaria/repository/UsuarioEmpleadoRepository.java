package com.veterinaria.backend_veterinaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.backend_veterinaria.models.Persona;
import com.veterinaria.backend_veterinaria.models.UsuarioEmpleado;

public interface UsuarioEmpleadoRepository extends JpaRepository<UsuarioEmpleado, Integer> {
    Optional<Persona> findByUserName(String userName);
    // Aquí puedes agregar métodos personalizados si es necesario
    
}
