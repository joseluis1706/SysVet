package com.veterinaria.backend_veterinaria.models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Producto implements Serializable {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    public String nombreProducto;
    public String descripcionProducto;
    public String tipoProducto;
    public Date fechaVencimientoProducto;
    public float valorProducto;
    public int stockProducto;    
  }
