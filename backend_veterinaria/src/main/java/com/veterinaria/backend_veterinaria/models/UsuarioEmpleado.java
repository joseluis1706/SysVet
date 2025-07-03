package com.veterinaria.backend_veterinaria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class UsuarioEmpleado {
    @Id
    public int idUsuario;

    @ManyToOne
    @JoinColumn(name = "idRol", referencedColumnName = "idRol")
    public Rol idRol;

    @OneToOne
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    public Persona idPersona;
}
