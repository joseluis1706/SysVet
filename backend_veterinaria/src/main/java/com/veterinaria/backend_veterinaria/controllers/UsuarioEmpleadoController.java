package com.veterinaria.backend_veterinaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.backend_veterinaria.DTOs.ResponseDTO;
import com.veterinaria.backend_veterinaria.models.UsuarioEmpleado;
import com.veterinaria.backend_veterinaria.services.UsuarioEmpleadoServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/UsuarioEmpleado")
@Tag(name = "Usuario Empleado", description = "Permite gestionar los usuarios")

public class UsuarioEmpleadoController {

    @Autowired
    private UsuarioEmpleadoServices service;

    @RequestMapping(path = "/Listar", method = RequestMethod.GET)
    @Operation(summary = "Listar Usuarios", description = "Permite listar las usuarios")
    public ResponseDTO listar() {
        return new ResponseDTO("success", "", service.listarUsuarioEmpleado());
    }

    // Guardar un nuevo cliente
    @RequestMapping(path = "/Guardar", method = RequestMethod.POST)
    @Operation(summary = "Guardar Usuario", description = "Permite guardar un nuevo usuario")
    public ResponseDTO guardar(@RequestBody UsuarioEmpleado usuario) {
        return new ResponseDTO("success", "", service.guardarUsuarioEmpleado(usuario));
    }

    // Eliminar un cliente por su ID
    @RequestMapping(path = "/Eliminar/{id}", method = RequestMethod.DELETE)
    @Operation(summary = "Eliminar usuario", description = "Permite eliminar un usuario por su ID")
    public ResponseDTO eliminar(@PathVariable int id) {
        if (service.eliminarUsuarioEmpleado(id)) {
            return new ResponseDTO("success", "Cliente eliminado correctamente", "");
        }
        return new ResponseDTO("error", "Cliente no encontrado", "");
    }

    // Consultar un cliente por su ID
    @RequestMapping(path = "/Consultar/{id}", method = RequestMethod.GET)
    @Operation(summary = "Consultar usuario por ID", description = "Permite consultar un usuario por su ID")
    public ResponseDTO consultar(@PathVariable int id) {
        if (service.consultarUsuarioEmpleadoPorId(id).isEmpty()) {
            return new ResponseDTO("error", "Cliente no encontrado", "");
        }
        return new ResponseDTO("success", "", service.consultarUsuarioEmpleadoPorId(id));
    }   

    // Actualizar un cliente por su ID
    @RequestMapping(path = "/Actualizar/{id}", method = RequestMethod.PUT)
    @Operation(summary = "Actualizar usuario", description = "Permite actualizar un usuario por su ID")
    public ResponseDTO actualizar(@PathVariable int id, @RequestBody UsuarioEmpleado usuario) {
        if (service.consultarUsuarioEmpleadoPorId(id).isEmpty()) {
            return new ResponseDTO("error", "Cliente no encontrado", "");
        }
        return new ResponseDTO("success", "", service.actualizarUsuarioEmpleado(id, usuario));
    }
}
