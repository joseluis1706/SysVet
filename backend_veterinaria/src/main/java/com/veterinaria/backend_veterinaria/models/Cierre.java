package com.veterinaria.backend_veterinaria.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cierre {
    @Id
    public int idCierre;
    public Date fechaCierre;
    public float montoInicial;
    public float montoFinal;
    public float diferencia;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    public UsuarioEmpleado idUsuario;
}
