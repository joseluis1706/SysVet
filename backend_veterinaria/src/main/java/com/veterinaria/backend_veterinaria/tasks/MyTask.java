package com.veterinaria.backend_veterinaria.tasks;

import java.time.LocalDateTime;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.veterinaria.backend_veterinaria.models.RevokedToken;
import com.veterinaria.backend_veterinaria.repository.RevokedTokenRepository;

@Component
public class MyTask {
    
    @Autowired
    private RevokedTokenRepository revokedTokenRepository;

    // Ejecuta cada hora
    @Scheduled(fixedDelay = ((1000) * 60) * 60) // 1 hora
    public void tarea() {
       LocalDateTime actual = LocalDateTime.now();
       List<RevokedToken> revokedTokens = revokedTokenRepository.findAll()
               .stream()
               .filter(token -> token.getExpirationDate().isBefore(actual))
               .toList();
               
         if (!revokedTokens.isEmpty()) {
            revokedTokenRepository.deleteAll(revokedTokens);
         }
    }
}
