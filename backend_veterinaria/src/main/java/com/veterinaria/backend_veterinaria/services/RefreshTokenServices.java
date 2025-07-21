package com.veterinaria.backend_veterinaria.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.veterinaria.backend_veterinaria.models.Persona;
import com.veterinaria.backend_veterinaria.models.RefreshToken;
import com.veterinaria.backend_veterinaria.repository.PersonaRepository;
import com.veterinaria.backend_veterinaria.repository.RefreshTokenRepository;



@Service
public class RefreshTokenServices {

    private int refreshTokenDurationMs =  86400000;  // (1 dia) //604800000; // (7 días)

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public RefreshToken createRefreshToken(String username) {
        Persona persona = personaRepository.findByUserName(username).orElseThrow();
        RefreshToken token = new RefreshToken();
        token.setPersona(persona);
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate(
                Instant.now().plusMillis(refreshTokenDurationMs).atZone(ZoneId.systemDefault()).toLocalDateTime());
        return refreshTokenRepository.save(token);
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().isBefore(LocalDateTime.now())) {
            refreshTokenRepository.delete(token);
            throw new RuntimeException("Refresh token expirado");
        }
        return token;
    }

    @Transactional
    public void deleteByPersona(String userName) {
        Persona persona = personaRepository.findByUserName(userName).orElseThrow();
        refreshTokenRepository.deleteByPersona(persona);
    }

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }
    
}
