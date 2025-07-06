package com.veterinaria.backend_veterinaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.backend_veterinaria.DTOs.ResponseDTO;
import com.veterinaria.backend_veterinaria.models.Mascota;
import com.veterinaria.backend_veterinaria.services.MascotaServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/Mascotas")
@Tag(name = "Mascotas", description = "Permite gestionar las mascotas")

public class MascotaController {

     @Autowired
    private MascotaServices service;
    
    // Listar todas las mascotas
    @RequestMapping(path = "/Listar", method = RequestMethod.GET)
    @Operation(summary = "Listar Mascotas", description = "Permite listar las masotas")
    public ResponseDTO listar() {
        return new ResponseDTO("success", "", service.listarMascota());
    }   

    // Guardar una nueva mascota
    @RequestMapping(path = "/Guardar", method=RequestMethod.POST)
    @Operation(summary = "Guardar datos de Mascota ", description = "Permite guardar una nueva mascota")
    public ResponseDTO guardar(@RequestBody Mascota mascota) {
        return new ResponseDTO("success", "", service.guardaMascota(mascota));
    }

    // Eliminar una mascota por su ID
    @RequestMapping(path = "/Eliminar/{id}", method=RequestMethod.DELETE)
    @Operation(summary = "Eliminar Mascota", description = "Permite eliminar una mascota por su ID")
    public ResponseDTO eliminar(@PathVariable String id) {
        if(service.eliminarMascota(id)){
            return new ResponseDTO("success", "Mascota eliminada correctamente", "");
        } 
        return new ResponseDTO("error", "Mascota no encontrada", "");
    }

    // Consultar una mascota por su ID
    @RequestMapping(path = "/Consultar/{id}", method=RequestMethod.GET)
    @Operation(summary = "Consultar mascota por ID", description = "Permite consultar una mascota por su ID")
    public ResponseDTO consultar(@PathVariable String id) {
        if(service.consultarMascotaPorId(id).isEmpty()) {
            return new ResponseDTO("error", "Mascota no encontrada", "");
        }
        return new ResponseDTO("success", "", service.consultarMascotaPorId(id));
    }

    // Actualizar una mascota por su ID
    @RequestMapping(path = "/Actualizar/{id}", method=RequestMethod.PUT)
    @Operation(summary = "Actualizar mascota", description = "Permite actualizar una mascota por su ID")
    public ResponseDTO actualizar(@PathVariable String id, @RequestBody Mascota mascota) {
        return new ResponseDTO("success", "", service.actualizarMascota(id, mascota));
    }
}
