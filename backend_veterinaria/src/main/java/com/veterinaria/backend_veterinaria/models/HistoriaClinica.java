package com.veterinaria.backend_veterinaria.models;

import java.sql.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
public class HistoriaClinica {
    @Id
    public int idHistoriaClinica;
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
