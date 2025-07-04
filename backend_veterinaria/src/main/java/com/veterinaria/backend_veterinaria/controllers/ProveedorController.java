package com.veterinaria.backend_veterinaria.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.backend_veterinaria.DTOs.ResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/Proveedores")
@Tag(name = "Proveedores", description = "Permite listar los proveedores")

public class ProveedorController {
    @RequestMapping(path = "/Listar", method = RequestMethod.GET)
    @Operation(summary = "Listar proveedores", description = "Permite listar los proveedores")
    public ResponseDTO listar() {
        return new ResponseDTO("success", "", null);
    }
    
}
