package com.veterinaria.backend_veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.backend_veterinaria.models.Cierre;

public interface CierreRepository extends JpaRepository<Cierre, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    
}
