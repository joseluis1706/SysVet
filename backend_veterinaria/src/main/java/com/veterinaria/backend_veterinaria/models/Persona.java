package com.veterinaria.backend_veterinaria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Persona {
    @Id
    public String idPersona;
    public String nombre;
    public String apellido;
    public String telefono;
    public String email;
    public String direccion;
    public String contraseña;
}
