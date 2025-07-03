package com.veterinaria.backend_veterinaria.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Ventas {
    @Id
    public int idVenta;
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
