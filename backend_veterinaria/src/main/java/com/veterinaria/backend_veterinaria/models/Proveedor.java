package com.veterinaria.backend_veterinaria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Proveedor {
    @Id
    public int idProveedor;
    public String razonSocialProveedor;    
    public String nitProveedor;
    public String contactoProveedor;
    public String telefonoProveedor;
    public String emailProveedor;
    public String rucProveedor;
    public Boolean estadoProveedor; // Activo, Inactivo Preguntar a la tutora si es necesario
}
