package com.veterinaria.backend_veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.backend_veterinaria.models.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    
}
