package com.veterinaria.backend_veterinaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.backend_veterinaria.DTOs.ResponseDTO;
import com.veterinaria.backend_veterinaria.models.Vacuna;
import com.veterinaria.backend_veterinaria.services.VacunaServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/Vacunas")
@Tag(name = "Vacunas", description = "Permite gestionar las vacunas")

public class VacunaController {

    @Autowired
    private VacunaServices service;

    @RequestMapping(path = "/Listar", method = RequestMethod.GET)
    @Operation(summary = "Listar Vacunas", description = "Permite listar las vacunas")
    public ResponseDTO listar() {
        return new ResponseDTO("success", "", service.listarVacuna());
    }    

    @RequestMapping(path = "/Guardar", method = RequestMethod.POST)
    @Operation(summary = "Guardar datos de Vacuna", description = "Permite guardar una nueva vacuna")
    public ResponseDTO guardar(@RequestBody Vacuna vacuna) {
        return new ResponseDTO("success", "", service.guardarVacuna(vacuna));
    }

    @RequestMapping(path = "/Eliminar/{id}", method = RequestMethod.DELETE)
    @Operation(summary = "Eliminar Vacuna", description = "Permite eliminar una vacuna por su ID")
    public ResponseDTO eliminar(@PathVariable int id) {
        if(service.eliminarVacuna(id)) {
            return new ResponseDTO("success", "Vacuna eliminada correctamente", "");
        } 
        return new ResponseDTO("error", "Vacuna no encontrada", "");
    }

    @RequestMapping(path = "/Consultar/{id}", method = RequestMethod.GET)
    @Operation(summary = "Consultar vacuna por ID", description = "Permite consultar una vacuna por su ID")
    public ResponseDTO consultar(@PathVariable int id) {
        if(service.consultarVacunaPorId(id).isEmpty()) {
            return new ResponseDTO("error", "Vacuna no encontrada", "");
        }
        return new ResponseDTO("success", "", service.consultarVacunaPorId(id));
    }
    @RequestMapping(path = "/Actualizar/{id}", method = RequestMethod.PUT)
    @Operation(summary = "Actualizar Vacuna", description = "Permite actualizar una vacuna por  su ID")
    public ResponseDTO actualizar(@PathVariable int id, @RequestBody Vacuna vacuna) {   
        if(service.consultarVacunaPorId(id).isEmpty()) {
            return new ResponseDTO("error", "Vacuna no encontrada", "");
        }
        return new ResponseDTO("success", "", service.actualizarVacuna(id, vacuna));
    }

}   
