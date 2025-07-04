package com.veterinaria.backend_veterinaria.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.backend_veterinaria.DTOs.ResponseDTO;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMethod;



@RestController
@RequestMapping("/Productos")
@Tag(name = "Productos", description = "Permite gestionar los productos de la veterinaria")

public class ProductoController {
    @RequestMapping(path = "/Listar", method=RequestMethod.GET)
    @Operation(summary = "Listar productos", description = "Permite listar los productos disponibles en la veterinaria")
    public ResponseDTO listar(){
        return new ResponseDTO("success", "", null);
    }    
}
