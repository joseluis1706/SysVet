package com.veterinaria.backend_veterinaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.backend_veterinaria.models.Persona;
import com.veterinaria.backend_veterinaria.models.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    
    Optional<RefreshToken> findByToken(String token);
    
    void deleteByPersona(Persona persona);
    
}
