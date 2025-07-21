package com.veterinaria.backend_veterinaria.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.backend_veterinaria.repository.RevokedTokenRepository;

@Service
public class TokenBlackLstServices {

    @Autowired
    private RevokedTokenRepository revokedTokenRepository;

    public boolean isTokenRevoked(String token) {
        return revokedTokenRepository.existsByToken(token);
    }

    public void revokedToken(String token, LocalDateTime expirationDate) {
        if (!isTokenRevoked(token)) {
            revokedTokenRepository.save(new com.veterinaria.backend_veterinaria.models.RevokedToken(token, expirationDate));
        }
    }
    
}
