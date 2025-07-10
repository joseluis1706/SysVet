package com.veterinaria.backend_veterinaria.models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Compra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompra;
    public Date fechaCompra;
    public String tipoPagoCompra; // Efectivo, Tarjeta, Transferencia
    public float totalCompra;
    public String conceptoCompra;

    @ManyToOne
    @JoinColumn(name = "idProveedor")
    public Proveedor idProveedor; // Relación con Proveedor

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    public UsuarioEmpleado idUsuario; // Relación con Usuario que realiza la compra

    @ManyToOne
    @JoinColumn(name = "idProducto")
    public Producto idProducto; // Relación con Producto comprado
}
