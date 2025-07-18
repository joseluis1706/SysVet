package com.veterinaria.backend_veterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.backend_veterinaria.DTOs.HistoriaClinicaDTO;
import com.veterinaria.backend_veterinaria.models.HistoriaClinica;
import com.veterinaria.backend_veterinaria.models.Mascota;
import com.veterinaria.backend_veterinaria.models.UsuarioEmpleado;
import com.veterinaria.backend_veterinaria.repository.HistoriaClinicaRepository;
import com.veterinaria.backend_veterinaria.repository.MascotaRepository;
import com.veterinaria.backend_veterinaria.repository.UsuarioEmpleadoRepository;


@Service
public class HistoriaClinicaServices {

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private UsuarioEmpleadoRepository usuarioEmpleadoRepository;

    public HistoriaClinica guardarDesdeDTO(HistoriaClinicaDTO dto) {
        Mascota mascota = mascotaRepository.findById(dto.idMascota)
            .orElseThrow(() -> new RuntimeException("Mascota no encontrada con ID: " + dto.idMascota));

        UsuarioEmpleado persona = usuarioEmpleadoRepository.findById(dto.idPersona)
            .orElseThrow(() -> new RuntimeException("Persona no encontrada con ID: " + dto.idPersona));

        HistoriaClinica historia = new HistoriaClinica();
        historia.setFechaCreacion(dto.fechaCreacion);
        historia.setSintomas(dto.sintomas);
        historia.setDiagnostico(dto.diagnostico);
        historia.setTratamiento(dto.tratamiento);
        historia.setFechaUltimaActualizacion(dto.fechaUltimaActualizacion);
        historia.setObservaciones(dto.observaciones);
        historia.setIdMascota(mascota);
        historia.setIdPersona(persona);

        return historiaClinicaRepository.save(historia);
    }

    // Guarda una nueva historia clínica en la base de datos.
    /* public HistoriaClinica guardarHistoriaClinica(HistoriaClinica historiaClinica) {
        return historiaClinicaRepository.save(historiaClinica);
    } */

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
