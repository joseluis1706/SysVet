package com.veterinaria.backend_veterinaria.controllers;

import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.backend_veterinaria.DTOs.ResponseDTO;
import com.veterinaria.backend_veterinaria.models.Persona;
import com.veterinaria.backend_veterinaria.models.RefreshToken;
import com.veterinaria.backend_veterinaria.security.JwtUtil;
import com.veterinaria.backend_veterinaria.security.PasswordUtili;
import com.veterinaria.backend_veterinaria.services.RefreshTokenServices;
import com.veterinaria.backend_veterinaria.services.TokenBlackLstServices;
import com.veterinaria.backend_veterinaria.services.UsuarioEmpleadoServices;

import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.tags.Tag;

// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticación", description = "Verificación de usuarios")
public class AutenticacionController {

    @Autowired
    private UsuarioEmpleadoServices service;

    @Autowired
    private RefreshTokenServices refreshTokenService;

    @Autowired
    private JwtUtil jwt;

    @Autowired
    private TokenBlackLstServices tokenBlackLstService;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    @Operation(summary = "Autenticación", description = "Verificación de usuarios del sistema")
    public ResponseDTO login(@RequestParam String username, @RequestParam String password, @RequestParam String rol) {
        try {
            Persona usuario = service.findByUserName(username)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            if (!usuario.contraseña.equals(PasswordUtili.hashPassword(password))) {
                return new ResponseDTO("error", "Credenciales inválidas", false);
            }

            if(rol == "Admin"){
                if (usuario.contraseña == null) {
                    return new ResponseDTO("error", "Rol no autorizado", false);
                }
            }           

            String token = jwt.generateToken(usuario.userName, usuario.nombre, usuario.apellido, 1,rol);
            RefreshToken refreshToken = refreshTokenService.createRefreshToken(username);

            return new ResponseDTO("success", "Usuario Autenticado", Map.of(
                    "accessToken", token,
                    "refreshToken", refreshToken.getToken()));
        } catch (Exception e) {
            return new ResponseDTO("error", "Tiene una sesión abierta",false);
        }
    }

    @RequestMapping(path = "/refresh", method = RequestMethod.POST)
    @Operation(summary = "Refrescar Token", description = "Actualización de token")
    public ResponseDTO refresh(@RequestBody Map<String, String> request) {
        String requestToken = request.get("refresh");
        String resquestRol = request.get("rol");
        try {
            return refreshTokenService.findByToken(requestToken)
                    .map(refreshTokenService::verifyExpiration)
                    .map(RefreshToken::getPersona)
                    .map(usuario -> {
                        String newAccessToken = jwt.generateToken(usuario.userName, usuario.nombre, usuario.apellido,
                                1,resquestRol);
                        Map<String, String> tokens = new HashMap<>();
                        tokens.put("accessToken", newAccessToken);
                        tokens.put("refreshToken", requestToken);
                        return new ResponseDTO("success", "Token refrescado", tokens);
                    })
                    .orElseThrow(() -> new RuntimeException("Refresh token no encontrado"));
        } catch (Exception e) {
            return new ResponseDTO("error", "No se pudo refrescar el token", null);
        }
    }


@RequestMapping(path = "/logout", method = RequestMethod.POST)
@Operation(summary = "Cierre de Sesion", description = "Terminar sesión de usuario")
public ResponseDTO logout(@RequestHeader("Authorization") String authHeader) {
    // Extraer token del header
    String token = authHeader.replace("Bearer ", "");
    Claims claims = jwt.getClaims(token);
    String username = claims.getSubject();

    refreshTokenService.deleteByPersona(username);

    // Eliminar el token de acceso del usuario
    tokenBlackLstService.revokedToken(token,
        claims.getExpiration().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());

    return new ResponseDTO("success", "Sesión cerrada", true);
}


    /* @RequestMapping(path = "/logout", method = RequestMethod.POST)
    @Operation(summary = "Cierre de Sesion", description = "Terminar sesión de usuario")
    public ResponseDTO logout(@RequestBody Map<String, String> resquest) {
        String username = resquest.get("username");
        String token = resquest.get("token");
        Claims claims = jwt.getClaims(token);

        refreshTokenService.deleteByPersona(username);

        // Eliminar el token de acceso del usuario
        tokenBlackLstService.revokedToken(token, claims.getExpiration().toInstant()
                .atZone(java.time.ZoneId.systemDefault()).toLocalDateTime());

        return new ResponseDTO("success", "Sesión cerrada", true);
    } 
     */
}
