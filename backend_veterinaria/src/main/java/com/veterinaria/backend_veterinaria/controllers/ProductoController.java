package com.veterinaria.backend_veterinaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.backend_veterinaria.DTOs.ResponseDTO;
import com.veterinaria.backend_veterinaria.models.Producto;
import com.veterinaria.backend_veterinaria.services.ProductoServices;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMethod;



@RestController
@RequestMapping("/Productos")
@Tag(name = "Productos", description = "Permite gestionar los productos de la veterinaria")

public class ProductoController {

    @Autowired
    private ProductoServices service;    

    @RequestMapping(path = "/Listar", method=RequestMethod.GET)
    @Operation(summary = "Listar productos", description = "Permite listar los productos disponibles en la veterinaria")
    public ResponseDTO listar() {
        return new ResponseDTO("success", "", service.listarProductos());
    }    

    @RequestMapping(path = "/Guardar", method=RequestMethod.POST)
    @Operation(summary = "Guardar producto", description = "Permite guardar un nuevo producto en la veterinaria")
    public ResponseDTO guardar(@RequestBody Producto producto) {
        return new ResponseDTO("success", "", service.guardaProducto(producto));
    }

    @RequestMapping(path = "/Eliminar/{id}", method=RequestMethod.DELETE)
    @Operation(summary = "Eliminar producto", description = "Permite eliminar un producto por su ID")
    public ResponseDTO eliminar(@PathVariable int id) {
        if(service.eliminarProducto(id)){
            return new ResponseDTO("success", "Producto eliminado correctamente", "");
        } 
        return new ResponseDTO("error", "Producto no encontrado", "");
    }

    @RequestMapping(path = "/Consultar/{id}", method=RequestMethod.GET)
    @Operation(summary = "Consultar producto por ID", description = "Permite consultar un producto por su ID")
    public ResponseDTO consultar(@PathVariable int id) {
        if(service.consultarProductoPorId(id).isEmpty()) {
            return new ResponseDTO("error", "Producto no encontrado", "");
        }
        return new ResponseDTO("success", "", service.consultarProductoPorId(id));
    }

    @RequestMapping(path = "/Actualizar/{id}", method=RequestMethod.PUT)
    @Operation(summary = "Actualizar producto", description = "Permite actualizar un producto por su ID")
    public ResponseDTO actualizar(@PathVariable int id, @RequestBody Producto producto) {
        return new ResponseDTO("success", "", service.actualizarProducto(id, producto));
    }
}