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
public class Ventas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;
    public Date fechaVenta;
    public float totalVenta;
    public String formaPago; // Efectivo, Tarjeta, Transferencia

    @ManyToOne
    @JoinColumn(name = "idCliente")
    public Cliente idCliente; // Referencia al cliente que realiza la compra preguntar a la tutora si es correcto

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    public UsuarioEmpleado idUsuario; // Referencia al usuario que registra la venta
}
