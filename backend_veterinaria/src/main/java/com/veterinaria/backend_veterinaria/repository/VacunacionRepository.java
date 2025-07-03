package com.veterinaria.backend_veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.backend_veterinaria.models.Vacunacion;

public interface VacunacionRepository extends JpaRepository<Vacunacion, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    
}
