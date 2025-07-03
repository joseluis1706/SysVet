package com.veterinaria.backend_veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.backend_veterinaria.models.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, String> {}  

