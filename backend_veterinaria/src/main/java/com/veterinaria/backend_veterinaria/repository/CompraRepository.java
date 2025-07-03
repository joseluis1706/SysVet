package com.veterinaria.backend_veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.backend_veterinaria.models.Compra;

public interface CompraRepository extends JpaRepository<Compra, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    
}
