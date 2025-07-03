package com.veterinaria.backend_veterinaria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DetalleVenta {
    @Id
    public int idDetalleVenta;
    public int cantidadProducto;
    public float precioUnitario;
    public float descuento; // Descuento aplicado al producto
    public float iva; // Impuesto al Valor Agregado aplicado al producto
    public float subtotal; // Total del detalle (cantidad * precioUnitario)
    public float totalIva; // Total del IVA aplicado al detalle 
    public float totalDescuento; // Total del descuento aplicado al detalle
    public float total; // Total final del detalle (subtotal + totalIva - totalDescuento)

    @ManyToOne
    @JoinColumn(name = "idProducto")
    public Producto idProducto; // Referencia al producto vendido

    @ManyToOne
    @JoinColumn(name = "idVenta")
    public Ventas idVentas; // Referencia a la venta a la que pertenece este detalle
}
