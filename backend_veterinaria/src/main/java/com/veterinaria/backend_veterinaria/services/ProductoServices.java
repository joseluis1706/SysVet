package com.veterinaria.backend_veterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.backend_veterinaria.models.Producto;
import com.veterinaria.backend_veterinaria.repository.ProductoRepository;

@Service
public class ProductoServices {
    
    @Autowired
    private ProductoRepository productoRepository;
    
    // Guarda un producto en la base de datos.  
    public Producto guardaProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Lista todos los productos de la base de datos.
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    // Elimina un producto por su ID.
    public boolean eliminarProducto(int id) {
        if(!productoRepository.existsById(id)) {
            return false; // Producto no encontrado
        }
         // Eliminar el producto
        productoRepository.deleteById(id);
        return true;
    }

    // Consulta un producto por su ID.
    public Optional<Producto>consultarProductoPorId(int id) {
        return productoRepository.findById(id);
    }

    // Actualiza un producto por su ID.
    public Producto actualizarProducto(int id, Producto producto) {
        Optional<Producto> value = productoRepository.findById(id);
        value.get().nombreProducto = producto.nombreProducto;
        value.get().descripcionProducto = producto.descripcionProducto;
        value.get().tipoProducto = producto.tipoProducto;
        value.get().fechaVencimientoProducto = producto.fechaVencimientoProducto;
        value.get().valorProducto = producto.valorProducto;
        value.get().stockProducto = producto.stockProducto;
        
        productoRepository.save(value.get());
        return (value.get());
    }
}
