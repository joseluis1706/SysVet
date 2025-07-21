package com.veterinaria.backend_veterinaria.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JwtUtil {
    
    // Clave secreta de al menos 32 caracteres (256 bits)
    private static final String SECRET = "6a7f9d2e98cba4326f7e0ac9d18c10be";

    private SecretKey key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    // Generar token válido por 1 hora
    public String generateToken(String username,String name, String lastname, int horas, String rol) {
        return Jwts.builder()
                .setSubject(username)
                .claim("name", name)
                .claim("lastname", lastname)
                .claim("rol", rol)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (3600_000)*horas)) // 1 hora
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Extraer el usuario del token
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Verificar si el token ya expiró
    public boolean isTokenExpired(String token) {
        Date expiration = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }

    // Validar token completo
    public boolean validateToken(String token) {
        try {
            return !isTokenExpired(token);
        } catch (JwtException e) {
            return false;
        }
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
