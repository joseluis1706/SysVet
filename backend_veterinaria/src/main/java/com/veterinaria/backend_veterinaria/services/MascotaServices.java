package com.veterinaria.backend_veterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.backend_veterinaria.models.Mascota;
import com.veterinaria.backend_veterinaria.repository.MascotaRepository;


@Service
public class MascotaServices {

    @Autowired
    private MascotaRepository mascotaRepository;
    
    // Guarda una nueva mascota en la base de datos. 
    public Mascota guardarMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    // Lista todas las mascotas.
    public List<Mascota> listarMascota() {
        return mascotaRepository.findAll();
    }

    // Elimina una mascota por su ID.
    public boolean eliminarMascota(Long id) {
        if(!mascotaRepository.existsById(id)) {
            return false; // Mascota no encontrada
        }
         // Elimina la mascota
        mascotaRepository.deleteById(id);
        return true;
    }

    // Consulta una mascota por su ID.
    public Optional<Mascota>consultarMascotaPorId(Long id) {
        return mascotaRepository.findById(id);
    }

    // Actualiza una mascota por su ID.
    public Mascota actualizarMascota(Long id, Mascota mascota) {
        Optional<Mascota> value = mascotaRepository.findById(id);
        value.get().nombreMascota = mascota.nombreMascota;
        value.get().especieMascota = mascota.especieMascota;
        value.get().razaMascota = mascota.razaMascota;
        value.get().colorMascota = mascota.colorMascota;
        value.get().fechaNacimiento = mascota.fechaNacimiento;
        value.get().sexoMascota = mascota.sexoMascota;
        value.get().pesoMascota = mascota.pesoMascota;
        value.get().estadoMascota = mascota.estadoMascota;
        value.get().fotoMascota = mascota.fotoMascota; // URL o ruta de la foto de la mascota   
        
        mascotaRepository.save(value.get());
        return (value.get());
    }    
}
