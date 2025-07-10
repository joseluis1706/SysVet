package com.veterinaria.backend_veterinaria.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Proveedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProveedor;
    public String razonSocialProveedor;    
    public String nitProveedor;
    public String contactoProveedor;
    public String telefonoProveedor;
    public String emailProveedor;
    public String rucProveedor;
    public Boolean estadoProveedor; // Activo, Inactivo Preguntar a la tutora si es necesario
}
