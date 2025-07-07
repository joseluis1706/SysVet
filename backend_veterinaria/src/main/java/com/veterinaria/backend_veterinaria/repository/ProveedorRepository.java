package com.veterinaria.backend_veterinaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.backend_veterinaria.models.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario

    List<Proveedor> findByRazonSocialProveedorContainingIgnoreCase(String nombre);
    
}
