package com.veterinaria.backend_veterinaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.backend_veterinaria.DTOs.ResponseDTO;
import com.veterinaria.backend_veterinaria.models.Compra;
import com.veterinaria.backend_veterinaria.services.CompraServices;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/Compras")
@Tag(name = "Compras", description = "Permite gestionar las compras")

public class ComprasController {

    @Autowired
    private CompraServices service; 

    // Listar todas las compras
    @RequestMapping(path = "/Listar", method = RequestMethod.GET)
    @Operation(summary = "Listar Compra", description = "Permite listar las compras")
    public ResponseDTO listar() {
        return new ResponseDTO("success", "", service.listarCompra() );
           
    }

    // Guardar una nueva compra
    @RequestMapping(path = "/Guardar", method=RequestMethod.POST)
    @Operation(summary = "Guardar compra", description = "Permite guardar una nueva compra")
    public ResponseDTO guardar(@RequestBody Compra compra) {
        return new ResponseDTO("success", "", service.guardarCompra(compra));
    }

    // Consultar una compra por su ID
    @RequestMapping(path = "/Consultar/{id}", method=RequestMethod.GET)
    @Operation(summary = "Consultar compra por ID", description = "Permite consultar una compra por su ID")
    public ResponseDTO consultar(@PathVariable int id) {
        if(service.consultarCompraPorId(id).isEmpty()) {
            return new ResponseDTO("error", "Compra no encontrada", "");
        }
        return new ResponseDTO("success", "", service.consultarCompraPorId(id));
    }

    // Actualizar una compra por su ID
    @RequestMapping(path = "/Actualizar/{id}", method=RequestMethod.PUT)
    @Operation(summary = "Actualizar compra", description = "Permite actualizar una compra por su ID")
    public ResponseDTO actualizar(@PathVariable int id, @RequestBody Compra compra) {
        return new ResponseDTO("success", "", service.actualizarCompra(id, compra));
    }
}
