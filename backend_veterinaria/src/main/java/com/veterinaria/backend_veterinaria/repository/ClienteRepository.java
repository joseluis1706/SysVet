package com.veterinaria.backend_veterinaria.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.backend_veterinaria.models.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

   // List<Persona> findBynombreCliente(String nombre);
    // Aquí puedes agregar métodos personalizados si es necesario
    
}
