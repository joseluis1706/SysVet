package com.veterinaria.backend_veterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.backend_veterinaria.models.Proveedor;
import com.veterinaria.backend_veterinaria.repository.ProveedorRepository;

@Service
public class ProveedorServices {

    @Autowired
    private ProveedorRepository proveedorRepository;
    
    // Guarda un proveedor en la base de datos.  
    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    // Lista todos los proveedores de la base de datos.
    public List<Proveedor> listarProveedor() {
        return proveedorRepository.findAll();
    }

    // Elimina un proveedor por su ID.
    public boolean eliminarProveedor(int id) {
        if(!proveedorRepository.existsById(id)) {
            return false; // Producto no encontrado
        }
         // Eliminar el proveedor
        proveedorRepository.deleteById(id);
        return true;
    }

    // Consulta un proveedor por su ID.
    public Optional<Proveedor>consultarProveedorPorId(int id) {
        return proveedorRepository.findById(id);
    }

    // Actualiza un proveedor por su ID.
    public Proveedor actualizarProveedor(int id, Proveedor proveedor) {
        Optional<Proveedor> value = proveedorRepository.findById(id);
        value.get().razonSocialProveedor = proveedor.razonSocialProveedor;
        value.get().nitProveedor = proveedor.nitProveedor;
        value.get().contactoProveedor = proveedor.contactoProveedor;
        value.get().telefonoProveedor = proveedor.telefonoProveedor;
        value.get().emailProveedor = proveedor.emailProveedor;
        value.get().rucProveedor = proveedor.rucProveedor;
        value.get().estadoProveedor = proveedor.estadoProveedor;

        // Guardar el producto actualizado        
        proveedorRepository.save(value.get());
        return (value.get());
    }
   
    // Consulta proveedores por nombre.
    public List<Proveedor> consultarProveedorPorNombre(String nombre) {
        return proveedorRepository.findByRazonSocialProveedorContainingIgnoreCase(nombre);
    }
}
