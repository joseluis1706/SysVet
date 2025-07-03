package com.veterinaria.backend_veterinaria.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Hospitalizacion {
    @Id
    public int idHospitalizacion;
    public Date fechaIngreso;
    public Date fechaSalida;
    public String observaciones;
    public String tratamiento;
    public float costoHospitalizacion;
    public String estadoHospitalizacion; // Estado de la hospitalización ("En curso", "Finalizada", "Cancelada")

    @ManyToOne
    @JoinColumn(name = "idMascota")
    public Mascota idMascota; // Referencia a la mascota hospitalizada
}
