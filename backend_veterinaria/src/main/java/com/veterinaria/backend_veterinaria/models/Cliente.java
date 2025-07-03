package com.veterinaria.backend_veterinaria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Cliente {
    @Id
    public int idCliente;

    @OneToOne
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    public Persona idPersona; 
    
}
