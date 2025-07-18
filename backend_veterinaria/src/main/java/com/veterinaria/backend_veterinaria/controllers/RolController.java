package com.veterinaria.backend_veterinaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.backend_veterinaria.DTOs.ResponseDTO;
import com.veterinaria.backend_veterinaria.models.Rol;
import com.veterinaria.backend_veterinaria.services.RolServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/Rol")
@Tag(name = "Rol", description = "Permite gestionar los roles")

public class RolController {

    @Autowired
    private RolServices service;

    // Listar todos los roles    
    @RequestMapping(path = "/Listar", method = RequestMethod.GET)
    @Operation(summary = "Listar roles", description = "Permite listar los roles")
    public ResponseDTO listar() {
        return new ResponseDTO("success", "", service.listarRol());
    }

    // Guardar un nuevo rol
    @RequestMapping(path = "/Guardar", method = RequestMethod.POST)
    @Operation(summary = "Guardar rol", description = "Permite guardar un nuevo rol")
    public ResponseDTO guardar(@RequestBody Rol rol) {
        return new ResponseDTO("success", "", service.guardarRol(rol));
    }

    // Eliminar un rol por su ID
    @RequestMapping(path = "/Eliminar/{id}", method = RequestMethod.DELETE)
    @Operation(summary = "Eliminar rol", description = "Permite eliminar un rol por su ID")
    public ResponseDTO eliminar(@PathVariable int id) {
        if (service.eliminarRol(id)) {
            return new ResponseDTO("success", "Rol eliminado correctamente", "");
        }
        return new ResponseDTO("error", "Rol no encontrado", "");
    }

    // Consultar un rol por su ID
    @RequestMapping(path = "/Consultar/{id}", method = RequestMethod.GET)
    @Operation(summary = "Consultar rol por ID", description = "Permite consultar un rol por su ID")
    public ResponseDTO consultar(@PathVariable int id) {
        if (service.consultarRolPorId(id).isEmpty()) {
            return new ResponseDTO("error", "Rol no encontrado", "");
        }
        return new ResponseDTO("success", "", service.consultarRolPorId(id));
    }

    // Actualizar un rol por su ID
    @RequestMapping(path = "/Actualizar/{id}", method = RequestMethod.PUT)
    @Operation(summary = "Actualizar rol", description = "Permite actualizar un rol por su ID")
    public ResponseDTO actualizar(@PathVariable int id, @RequestBody Rol rol) {
        if (service.consultarRolPorId(id).isEmpty()) {
            return new ResponseDTO("error", "Rol no encontrado", "");
        }
        return new ResponseDTO("success", "", service.actualizarRol(id, rol));
    }  
}
