package com.veterinaria.backend_veterinaria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vacuna {
    @Id
    public int idVacuna;
    public String nombreVacuna;
    public String descripcionVacuna;
    public String especieAnimal;
    public String enfermedadAsociada;
    public int edadRecomendada;
    public int dosis;
    public int intervaloDosis;    
}
