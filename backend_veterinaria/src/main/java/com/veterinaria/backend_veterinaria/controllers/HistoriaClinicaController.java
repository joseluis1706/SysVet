package com.veterinaria.backend_veterinaria.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.backend_veterinaria.DTOs.ResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/HistoriaClinica")
@Tag(name = "Historia Clinica", description = "Permite gestionar las historias clinicas")

public class HistoriaClinicaController {
    @RequestMapping(path = "/Listar", method = RequestMethod.GET)
    @Operation(summary = "Listar Historias Clinicas", description = "Permite listar las historias clinicas")
    public ResponseDTO listar() {
        return new ResponseDTO("success", "", null);
    }
    
}
