package com.veterinaria.backend_veterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.backend_veterinaria.models.Vacuna;
import com.veterinaria.backend_veterinaria.repository.VacunaRepository;

@Service
public class VacunaServices {

    @Autowired
    private VacunaRepository vacunaRepository;

    // Guarda una nueva vacuna en la base de datos. 
    public Vacuna guardarVacuna(Vacuna vacuna) {
        return vacunaRepository.save(vacuna);
    }

    // Lista todas las vacunas.
    public List<Vacuna> listarVacuna() {
        return vacunaRepository.findAll();
    }

    // Elimina una vacuna por su ID.
    public boolean eliminarVacuna(int id) {
        if(!vacunaRepository.existsById(id)) {
            return false; // Vacuna no encontrada
        }
         // Elimina la vacuna
        vacunaRepository.deleteById(id);
        return true;
    }

    // Consulta una vacuna por su ID.
    public Optional<Vacuna>consultarVacunaPorId(int id) {
        return vacunaRepository.findById(id);
    }

    // Actualiza una vacuna por su ID.
    public Vacuna actualizarVacuna(int id, Vacuna vacuna) {
        Optional<Vacuna> value = vacunaRepository.findById(id);
        value.get().nombreVacuna = vacuna.nombreVacuna;
        value.get().descripcionVacuna = vacuna.descripcionVacuna;
        value.get().especieAnimal = vacuna.especieAnimal;
        value.get().enfermedadAsociada = vacuna.enfermedadAsociada;
        value.get().edadRecomendada = vacuna.edadRecomendada;
        value.get().dosis = vacuna.dosis;
        value.get().intervaloDosis = vacuna.intervaloDosis;       
        
        vacunaRepository.save(value.get());
        return (value.get());
    }    
    
}
