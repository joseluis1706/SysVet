package com.veterinaria.backend_veterinaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.backend_veterinaria.DTOs.ResponseDTO;
import com.veterinaria.backend_veterinaria.models.Proveedor;
import com.veterinaria.backend_veterinaria.services.ProveedorServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/Proveedores")
@Tag(name = "Proveedores", description = "Permite listar los proveedores")

public class ProveedorController {

    @Autowired
    private ProveedorServices service;
    
    // Listar todos los proveedores    
    @RequestMapping(path = "/Listar", method = RequestMethod.GET)
    @Operation(summary = "Listar proveedores", description = "Permite listar los proveedores")
    public ResponseDTO listar() {
        return new ResponseDTO("success", "", service.listarProveedor());
    }

    // Guardar un nuevo proveedor
    @RequestMapping(path = "/Guardar", method = RequestMethod.POST)
    @Operation(summary = "Guardar proveedor", description = "Permite guardar un nuevo proveedor")
    public ResponseDTO guardar(@RequestBody Proveedor proveedor) {
        return new ResponseDTO("success", "", service.guardarProveedor(proveedor));
    }

    // Eliminar un proveedor por su ID
    @RequestMapping(path = "/Eliminar/{id}", method = RequestMethod.DELETE)
    @Operation(summary = "Eliminar proveedor", description = "Permite eliminar un proveedor por su ID")
    public ResponseDTO eliminar(@PathVariable int id) {
        if (service.eliminarProveedor(id)) {
            return new ResponseDTO("success", "Proveedor eliminado correctamente", "");
        }
        return new ResponseDTO("error", "Proveedor no encontrado", "");
    }

    // Consultar un proveedor por su ID
    @RequestMapping(path = "/Consultar/{id}", method = RequestMethod.GET)
    @Operation(summary = "Consultar proveedor por ID", description = "Permite consultar un proveedor por su ID")
    public ResponseDTO consultar(@PathVariable int id) {
        if (service.consultarProveedorPorId(id).isEmpty()) {
            return new ResponseDTO("error", "Proveedor no encontrado", "");
        }
        return new ResponseDTO("success", "", service.consultarProveedorPorId(id));
    }   

    // Actualizar un proveedor por su ID
    @RequestMapping(path = "/Actualizar/{id}", method = RequestMethod.PUT)
    @Operation(summary = "Actualizar proveedor", description = "Permite actualizar un proveedor por su ID")
    public ResponseDTO actualizar(@PathVariable int id, @RequestBody Proveedor proveedor) {
        if (service.consultarProveedorPorId(id).isEmpty()) {
            return new ResponseDTO("error", "Proveedor no encontrado", "");
        }
        return new ResponseDTO("success", "", service.actualizarProveedor(id, proveedor));
    }    
   
    // Consultar proveedores por nombre
    @RequestMapping(path = "/ConsultarPorNombre/{nombre}", method = RequestMethod.GET)
    @Operation(summary = "Consultar proveedores por nombre", description = "Permite consultar proveedores por su nombre")
    public ResponseDTO consultarPorNombre(@PathVariable String nombre) {
        if (service.consultarProveedorPorNombre(nombre).isEmpty()) {
            return new ResponseDTO("error", "No se encontraron proveedores con ese nombre", "");
        }
        return new ResponseDTO("success", "", service.consultarProveedorPorNombre(nombre));
    }       
}
