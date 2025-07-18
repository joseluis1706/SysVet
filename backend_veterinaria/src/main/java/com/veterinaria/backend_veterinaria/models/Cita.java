package com.veterinaria.backend_veterinaria.models;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cita implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCita;
    public Date fechaCita;
    public Time horaCita;
    public String motivoCita;
    public String tipoCita; // Tipo de cita (consulta, peluqueria, etc.)
    public float costoCita;
    public String estadoCita; // estado de la cita (pendiente, confirmada, cancelada, etc.)

    @ManyToOne
    @JoinColumn(name = "idPersona")
    public Cliente idPersona; // ID del cliente asociado a la cita preguntar a la tutora si es correcto

    @ManyToOne
    @JoinColumn(name = "idMascota")
    public Mascota idMascota; // ID de la mascota asociada a la cita
}
