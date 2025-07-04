package com.veterinaria.backend_veterinaria.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.backend_veterinaria.DTOs.ResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/Hospitalizacion")
@Tag(name = "Hospitalizacion", description = "Permite gestionar las hospitalizaciones")

public class HospitalizacionController {
    @RequestMapping(path = "/Listar", method = RequestMethod.GET)
    @Operation(summary = "Listar pacientes hospitalizados", description = "Permite listar las hospitalizaciones")
    public ResponseDTO listar() {
        return new ResponseDTO("success", "", null);
    }
    
}
