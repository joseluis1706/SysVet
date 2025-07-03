package com.veterinaria.backend_veterinaria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Rol {
    @Id
    public int idRol;
    public String nombreRol;

}
