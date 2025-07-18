package com.veterinaria.backend_veterinaria.models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Mascota implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMascota;
    public String nombreMascota;
    public String especieMascota;
    public String razaMascota;
    public String colorMascota;
    public Date fechaNacimiento;
    public String sexoMascota;
    public float pesoMascota;
    public String estadoMascota;
    public String fotoMascota; // URL o ruta de la foto de la mascota

    @ManyToOne
    @JoinColumn(name = "idPersona")
    public Cliente idPersona; // Relación con Cliente

}
