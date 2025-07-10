package com.veterinaria.backend_veterinaria.models;

import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class UsuarioEmpleado extends Persona {
   // @Id
   // public int idUsuario;

    @ManyToOne
    @JoinColumn(name = "idRol", referencedColumnName = "idRol")
    public Rol idRol;   
}
