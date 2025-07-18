package com.veterinaria.backend_veterinaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.backend_veterinaria.DTOs.ResponseDTO;
import com.veterinaria.backend_veterinaria.models.Cliente;
import com.veterinaria.backend_veterinaria.services.ClienteServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/Clientes")
@Tag(name = "Clientes", description = "Permite listar los clientes")

public class ClienteController {
    
    @Autowired
    private ClienteServices service;

    // Listar todos los clientes    
    @RequestMapping(path = "/Listar", method = RequestMethod.GET)
    @Operation(summary = "Listar clientes", description = "Permite listar los clientes")
    public ResponseDTO listar() {
        return new ResponseDTO("success", "", service.listarCliente());
    }

    // Guardar un nuevo cliente
    @RequestMapping(path = "/Guardar", method = RequestMethod.POST)
    @Operation(summary = "Guardar cliente", description = "Permite guardar un nuevo cliente")
    public ResponseDTO guardar(@RequestBody Cliente cliente) {
        return new ResponseDTO("success", "", service.guardarCliente(cliente));
    }

    // Eliminar un cliente por su ID
    @RequestMapping(path = "/Eliminar/{id}", method = RequestMethod.DELETE)
    @Operation(summary = "Eliminar cliente", description = "Permite eliminar un cliente por su ID")
    public ResponseDTO eliminar(@PathVariable int id) {
        if (service.eliminarCliente(id)) {
            return new ResponseDTO("success", "Cliente eliminado correctamente", "");
        }
        return new ResponseDTO("error", "Cliente no encontrado", "");
    }

    // Consultar un cliente por su ID
    @RequestMapping(path = "/Consultar/{id}", method = RequestMethod.GET)
    @Operation(summary = "Consultar cliente por ID", description = "Permite consultar un cliente por su ID")
    public ResponseDTO consultar(@PathVariable int id) {
        if (service.consultarClientePorId(id).isEmpty()) {
            return new ResponseDTO("error", "Cliente no encontrado", "");
        }
        return new ResponseDTO("success", "", service.consultarClientePorId(id));
    }   

    // Actualizar un cliente por su ID
    @RequestMapping(path = "/Actualizar/{id}", method = RequestMethod.PUT)
    @Operation(summary = "Actualizar cliente", description = "Permite actualizar un cliente por su ID")
    public ResponseDTO actualizar(@PathVariable int id, @RequestBody Cliente cliente) {
        if (service.consultarClientePorId(id).isEmpty()) {
            return new ResponseDTO("error", "Cliente no encontrado", "");
        }
        return new ResponseDTO("success", "", service.actualizarCliente(id, cliente));
    }    
   
    // Consultar cliente por nombre
    /* @RequestMapping(path = "/ConsultarPorNombre/{nombre}", method = RequestMethod.GET)
    @Operation(summary = "Consultar cliente por nombre", description = "Permite consultar cliente por su nombre")
    public ResponseDTO consultarPorNombre(@PathVariable String nombre) {
        if (service.consultarClientePorNombre(nombre).isEmpty()) {
            return new ResponseDTO("error", "No se encontraron proveedores con ese nombre", "");
        }
        return new ResponseDTO("success", "", service.consultarClientePorNombre(nombre));
    }    */    
}
