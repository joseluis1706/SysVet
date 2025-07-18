package com.veterinaria.backend_veterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.backend_veterinaria.models.Rol;
import com.veterinaria.backend_veterinaria.repository.RolRepository;

@Service
public class RolServices {

    @Autowired
    private RolRepository rolRepository;

    public Rol guardarRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public List<Rol> listarRol() {
        return rolRepository.findAll();
    }

    public Optional<Rol> consultarRolPorId(int rol) {
        return rolRepository.findById(rol);
    }

    public boolean eliminarRol(int rol) {
        if(!rolRepository.existsById(rol)){
            return false;
        }
        rolRepository.deleteById(rol);
        return true;
    }

    // Actualiza el rol por su ID.
    public Rol actualizarRol(int id, Rol rol) {
        Optional<Rol> value = rolRepository.findById(id);
        value.get().nombreRol = rol.nombreRol;        
                
        rolRepository.save(value.get());
        return (value.get());
    } 
}
