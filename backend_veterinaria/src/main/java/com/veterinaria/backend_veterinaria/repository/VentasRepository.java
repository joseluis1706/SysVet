package com.veterinaria.backend_veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.backend_veterinaria.models.Ventas;

public interface VentasRepository extends JpaRepository<Ventas, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    
}
