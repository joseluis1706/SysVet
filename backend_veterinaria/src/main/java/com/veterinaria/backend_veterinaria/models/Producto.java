package com.veterinaria.backend_veterinaria.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Producto {
  
    @Id
    public int idProducto;
    public String nombreProducto;
    public String descripcionProducto;
    public String tipoProducto;
    public Date fechaVencimientoProducto;
    public float valorProducto;
    public int stockProducto;
    
  }
