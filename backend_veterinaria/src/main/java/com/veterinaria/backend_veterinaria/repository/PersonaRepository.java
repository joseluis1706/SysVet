package com.veterinaria.backend_veterinaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.backend_veterinaria.models.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Optional<Persona> findByUserName(String userName);
    // Aquí puedes agregar métodos personalizados si es necesario
    
}
