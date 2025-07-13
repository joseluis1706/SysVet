package com.veterinaria.backend_veterinaria.models;

import java.io.Serializable;
import java.sql.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
public class HistoriaClinica implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistoriaClinica;
    public Date fechaCreacion;
    public String sintomas;
    public String diagnostico;
    public String tratamiento;
    public Date fechaUltimaActualizacion;
    public String observaciones;

    @OneToOne
    @JoinColumn(name = "idMascota")
    public Mascota idMascota;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    public UsuarioEmpleado idUsuario;

}
