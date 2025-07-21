package com.veterinaria.backend_veterinaria.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers(
                                        "/auth/**",               // Rutas públicas de login
                                        "/swagger-ui/**",         // Interfaz Swagger
                                        "/v3/api-docs/**",        // Documentación OpenAPI
                                        "/swagger-resources/**",  // Recursos Swagger
                                        "/webjars/**"             // Archivos JS/CSS de Swagger
                                ).permitAll()
                                .anyRequest().authenticated() // Todo lo demás requiere JWT
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    
}
