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
public class Vacunacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVacunacion;
    public Date fechaVacunacion;
    public int dosisAplicada;
    public Date fechaProximaDosis;
    public String observaciones;

    @ManyToOne
    @JoinColumn(name = "idMascota")
    public Mascota idMascota;

    @ManyToOne
    @JoinColumn(name = "idVacuna")
    public Vacuna idVacuna;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    public UsuarioEmpleado idUsuario;
}
