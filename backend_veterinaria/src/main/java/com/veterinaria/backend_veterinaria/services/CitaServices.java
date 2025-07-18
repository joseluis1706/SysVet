package com.veterinaria.backend_veterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.backend_veterinaria.models.Cita;
import com.veterinaria.backend_veterinaria.repository.CitaRepository;


@Service
public class CitaServices {

    @Autowired
    private CitaRepository citaRepository;

    // Guarda una nueva cita en la base de datos.
    public Cita guardarCita(Cita cita) {
        return citaRepository.save(cita);
    }

    // Lista todas las citas.
    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    // Elimina una cita por su ID.
    public boolean eliminarCita(int id) {
        if (!citaRepository.existsById(id)) {
            return false; // Cita no encontrada
        }
        // Elimina la cita
        citaRepository.deleteById(id);
        return true;
    }

    // Consulta una cita por su ID.
    public Optional<Cita>consultarCitaPorId(int id) {
        return citaRepository.findById(id);
    }

    // Actualiza una cita por su ID.
    public Cita actualizarCita(int id, Cita cita) {
        Optional<Cita> value = citaRepository.findById(id);
        value.get().fechaCita = cita.fechaCita;
        value.get().horaCita = cita.horaCita;
        value.get().motivoCita = cita.motivoCita;
        value.get().tipoCita = cita.tipoCita;
        value.get().costoCita = cita.costoCita;
        value.get().estadoCita = cita.estadoCita;
        value.get().idPersona = cita.idPersona; // Actualiza el cliente asociado
        value.get().idMascota = cita.idMascota; // Actualiza la mascota asociada

        citaRepository.save(value.get());
        return value.get();

    }    
}
