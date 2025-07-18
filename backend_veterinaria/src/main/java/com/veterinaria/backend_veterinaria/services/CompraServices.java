package com.veterinaria.backend_veterinaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.backend_veterinaria.models.Compra;
import com.veterinaria.backend_veterinaria.repository.CompraRepository;

@Service
public class CompraServices {
    
    @Autowired
    private CompraRepository compraRepository;
    
    // Guarda una compra en la base de datos.  
    public Compra guardarCompra(Compra compra) {
        return compraRepository.save(compra);
    }

    // Lista todas las compras de la base de datos.
    public List<Compra> listarCompra() {
        return compraRepository.findAll();
    }

    // Consulta una compra por su ID.
    public Optional<Compra>consultarCompraPorId(int id) {
        return compraRepository.findById(id);
    }

    // Actualiza una compra por su ID.
    public Compra actualizarCompra(int id, Compra compra) {
        Optional<Compra> value = compraRepository.findById(id);
        value.get().fechaCompra = compra.fechaCompra;
        value.get().tipoPagoCompra = compra.tipoPagoCompra;
        value.get().totalCompra = compra.totalCompra;
        value.get().conceptoCompra = compra.conceptoCompra;
        
        compraRepository.save(value.get());
        return (value.get());
    }
}
