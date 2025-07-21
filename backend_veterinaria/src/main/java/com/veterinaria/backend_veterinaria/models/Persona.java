package com.veterinaria.backend_veterinaria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {
    @Id
    public int idPersona;
    public String nombre;
    public String apellido;
    public String telefono;
    public String email;
    public String direccion;
    public String userName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String contraseña;
}
