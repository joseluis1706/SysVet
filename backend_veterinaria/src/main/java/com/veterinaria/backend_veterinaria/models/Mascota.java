package com.veterinaria.backend_veterinaria.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Mascota {
    @Id
    public String idMascota;
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
    @JoinColumn(name = "idCliente")
    public Cliente idCliente; // Relación con Cliente
}
