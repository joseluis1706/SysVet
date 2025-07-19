package com.veterinaria.backend_veterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.backend_veterinaria.models.Cliente;
import com.veterinaria.backend_veterinaria.repository.ClienteRepository;
import com.veterinaria.backend_veterinaria.security.PasswordUtili;

@Service
public class ClienteServices {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente guardarCliente(Cliente cliente) {
        if (cliente.contraseña != null && !cliente.contraseña.isEmpty()) {
            cliente.contraseña = PasswordUtili.hashPassword(cliente.contraseña);
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarCliente() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> consultarClientePorId(int cliente) {
        return clienteRepository.findById(cliente);
    }

    public boolean eliminarCliente(int cliente) {
        if(!clienteRepository.existsById(cliente)){
            return false;
        }
        clienteRepository.deleteById(cliente);
        return true;
    }

    // Actualiza un cliente por su ID.
    public Cliente actualizarCliente(int id, Cliente cliente) {
        Optional<Cliente> value = clienteRepository.findById(id);
        value.get().nombre = cliente.nombre;
        value.get().apellido = cliente.apellido;
        value.get().telefono = cliente.telefono;
        value.get().email = cliente.email;
        value.get().direccion = cliente.direccion;

        if (cliente.contraseña != null && !cliente.contraseña.isEmpty()) {
            value.get().contraseña = PasswordUtili.hashPassword(cliente.contraseña);
        } else {
            value.get().contraseña = value.get().contraseña; // Mantiene la contraseña anterior si no se proporciona una
                                                             // nueva
        }        
        clienteRepository.save(value.get());
        return (value.get());
    }    

    // Consulta cliente por nombre.
   /*  public List<Persona> consultarClientePorNombre(String nombre) {
        return clienteRepository.findBynombreCliente(nombre);
    } */
}
