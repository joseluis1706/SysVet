package com.veterinaria.backend_veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.backend_veterinaria.models.Vacuna;

public interface VacunaRepository extends JpaRepository<Vacuna, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    
}
