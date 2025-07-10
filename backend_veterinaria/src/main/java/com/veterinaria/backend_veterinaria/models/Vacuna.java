package com.veterinaria.backend_veterinaria.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vacuna implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVacuna;
    public String nombreVacuna;
    public String descripcionVacuna;
    public String especieAnimal;
    public String enfermedadAsociada;
    public int edadRecomendada;
    public int dosis;
    public int intervaloDosis;    
}
