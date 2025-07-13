package com.veterinaria.backend_veterinaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.backend_veterinaria.models.HistoriaClinica;

public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Long> {

    // Método para consultar una historia clínica por el nombre de la mascota
        List<HistoriaClinica> findByIdMascotaNombreMascota(String nombreMascota);
    
        // Aquí puedes agregar métodos personalizados si es necesario
    
}
