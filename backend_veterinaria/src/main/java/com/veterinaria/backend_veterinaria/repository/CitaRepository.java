package com.veterinaria.backend_veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.backend_veterinaria.models.Cita;

public interface CitaRepository extends JpaRepository<Cita, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    
}
