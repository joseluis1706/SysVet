package com.veterinaria.backend_veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.backend_veterinaria.models.Hospitalizacion;

public interface HospitalizacionRepository extends JpaRepository<Hospitalizacion, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    
}
