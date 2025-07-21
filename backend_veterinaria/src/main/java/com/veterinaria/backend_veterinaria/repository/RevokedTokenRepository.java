package com.veterinaria.backend_veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.backend_veterinaria.models.RevokedToken;

public interface RevokedTokenRepository extends JpaRepository<RevokedToken, Integer> {
    
   // Método para verificar si un token está revocado
    public boolean existsByToken(String token);
    
}
