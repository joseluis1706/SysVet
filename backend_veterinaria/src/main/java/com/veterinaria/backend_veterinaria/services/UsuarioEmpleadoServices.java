package com.veterinaria.backend_veterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.backend_veterinaria.models.UsuarioEmpleado;
import com.veterinaria.backend_veterinaria.repository.UsuarioEmpleadoRepository;
import com.veterinaria.backend_veterinaria.security.PasswordUtili;

@Service
public class UsuarioEmpleadoServices {

    @Autowired
    private UsuarioEmpleadoRepository usuarioEmpleadoRepository;

    public UsuarioEmpleado guardarUsuarioEmpleado(UsuarioEmpleado usuario) {
        if (usuario.contraseña != null && !usuario.contraseña.isEmpty()) {
            usuario.contraseña = PasswordUtili.hashPassword(usuario.contraseña);
        }
        return usuarioEmpleadoRepository.save(usuario);
    }

    public List<UsuarioEmpleado> listarUsuarioEmpleado() {
        return usuarioEmpleadoRepository.findAll();
    }

    public Optional<UsuarioEmpleado> consultarUsuarioEmpleadoPorId(int idUsuarioEmpleado) {
        return usuarioEmpleadoRepository.findById(idUsuarioEmpleado);
    }

    public boolean eliminarUsuarioEmpleado(int idUsuarioEmpleado) {
        if(!usuarioEmpleadoRepository.existsById(idUsuarioEmpleado)){
            return false;
        }
        usuarioEmpleadoRepository.deleteById(idUsuarioEmpleado);
        return true;
    }

    // Actualiza un UsuarioEmpleado por su ID.
    public UsuarioEmpleado actualizarUsuarioEmpleado(int id, UsuarioEmpleado usuarioEmpleado) {
        Optional<UsuarioEmpleado> value = usuarioEmpleadoRepository.findById(id);
        value.get().nombre = usuarioEmpleado.nombre;
        value.get().apellido = usuarioEmpleado.apellido;
        value.get().telefono = usuarioEmpleado.telefono;
        value.get().email = usuarioEmpleado.email;
        value.get().direccion = usuarioEmpleado.direccion;
        
        if (usuarioEmpleado.contraseña != null && !usuarioEmpleado.contraseña.isEmpty()) {
            value.get().contraseña = PasswordUtili.hashPassword(usuarioEmpleado.contraseña);
        } else {
            value.get().contraseña = value.get().contraseña; // Mantiene la contraseña anterior si no se proporciona una nueva
        }
                
        usuarioEmpleadoRepository.save(value.get());
        return (value.get());
    }    

    // Consulta UsuarioEmpleado por nombre.
   /*  public List<Persona> consultarUsuarioEmpleadoPorNombre(String nombre) {
        return UsuarioEmpleadoRepository.findBynombreUsuarioEmpleado(nombre);
    } */  

}
