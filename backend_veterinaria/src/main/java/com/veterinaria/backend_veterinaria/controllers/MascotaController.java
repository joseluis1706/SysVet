package com.veterinaria.backend_veterinaria.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.backend_veterinaria.DTOs.ResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/Mascotas")
@Tag(name = "Mascotas", description = "Permite gestionar las mascotas")

public class MascotaController {
    @RequestMapping(path = "/Listar", method = RequestMethod.GET)
    @Operation(summary = "Listar Mascotas", description = "Permite listar las masotas")
    public ResponseDTO listar() {
        return new ResponseDTO("success", "", null);
    }    
}
