package com.veterinaria.backend_veterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.backend_veterinaria.models.HistoriaClinica;
import com.veterinaria.backend_veterinaria.repository.HistoriaClinicaRepository;

@Service
public class HistoriaClinicaServices {

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    // Guarda una nueva historia clínica en la base de datos.
    public HistoriaClinica guardarHistoriaClinica(HistoriaClinica historiaClinica) {
        return historiaClinicaRepository.save(historiaClinica);
    }

    // Lista todas las historias clínicas.
    public List<HistoriaClinica> listarHistoriasClinicas() {
        return historiaClinicaRepository.findAll();
    }

    // Elimina una historia clínica por su ID.
    public boolean eliminarHistoriaClinica(Long id) {
        if (!historiaClinicaRepository.existsById(id)) {
            return false; // Historia clínica no encontrada
        }
        // Elimina la historia clínica
        historiaClinicaRepository.deleteById(id);
        return true;
    }

    // Consulta una historia clínica por su ID.
    public Optional<HistoriaClinica> consultarHistoriaClinicaPorId(Long id) {
        return historiaClinicaRepository.findById(id);
    }

    // Consultar una historia clínica por el nombre de la mascota.
    public List<HistoriaClinica> consultarHistoriaClinicaPorNombreMascota(String nombreMascota) {
        return historiaClinicaRepository.findByIdMascotaNombreMascota(nombreMascota);
    }

    // Actualiza una historia clínica por su ID.
    public HistoriaClinica actualizarHistoriaClinica(Long id, HistoriaClinica historiaClinica) {
        Optional<HistoriaClinica> value = historiaClinicaRepository.findById(id);        
            value.get().fechaCreacion = historiaClinica.fechaCreacion;
            value.get().sintomas = historiaClinica.sintomas;
            value.get().diagnostico = historiaClinica.diagnostico;
            value.get().tratamiento = historiaClinica.tratamiento;
            value.get().fechaUltimaActualizacion = historiaClinica.fechaUltimaActualizacion;
            value.get().observaciones = historiaClinica.observaciones;           
            
            historiaClinicaRepository.save(value.get());
            return value.get();      
    }    
}
