package com.veterinaria.backend_veterinaria.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.backend_veterinaria.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
    // Aquí puedes agregar métodos personalizados si es necesario
    
}
