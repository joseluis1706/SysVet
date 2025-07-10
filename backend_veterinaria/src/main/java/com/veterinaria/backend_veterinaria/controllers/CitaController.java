package com.veterinaria.backend_veterinaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.backend_veterinaria.DTOs.ResponseDTO;
import com.veterinaria.backend_veterinaria.DTOs.ResponseEstadoCitaDTO;
import com.veterinaria.backend_veterinaria.models.Cita;
import com.veterinaria.backend_veterinaria.services.CitaServices;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/Citas")
@Tag(name = "Citas", description = "Permite gestionar las citas de los clientes y sus mascotas")

public class CitaController {

    @Autowired
    private CitaServices service;
    
    // Listar todas las citas
    @RequestMapping(path = "/Listar", method = RequestMethod.GET)
    @Operation(summary = "Listar Citas", description = "Permite listar las citas")
    public ResponseDTO listar() {
        return new ResponseDTO("success", "", service.listarCitas());
    }   

    // Registrar una nueva citas
    @RequestMapping(path = "/Guardar", method=RequestMethod.POST)
    @Operation(summary = "Guardar datos de Citas", description = "Permite guardar una nueva cita")
    public ResponseDTO guardar(@RequestBody Cita cita) {
        return new ResponseDTO("success", "", service.guardarCita(cita));
    }

    // Eliminar una Cita por su ID
    @RequestMapping(path = "/Eliminar/{id}", method=RequestMethod.DELETE)
    @Operation(summary = "Eliminar Cita", description = "Permite eliminar o Cancelar una Cita por su ID")
    public ResponseDTO eliminar(@PathVariable int id) {
        if(service.eliminarCita(id)){
            return new ResponseDTO("success", "Cita eliminada correctamente", "");
        } 
        return new ResponseDTO("error", "Cita no encontrada", "");
    }

    // Consultar una cita por su ID
    @RequestMapping(path = "/Consultar/{id}", method=RequestMethod.GET)
    @Operation(summary = "Consultar cita por ID", description = "Permite consultar una cita por su ID")
    public ResponseDTO consultar(@PathVariable int id) {
        if(service.consultarCitaPorId(id).isEmpty()) {
            return new ResponseDTO("error", "Cita no encontrada", "");
        }
        return new ResponseDTO("success", "", service.consultarCitaPorId(id));
    }

    // consultar citas por estado
    @RequestMapping(path = "/ConsultarEstado/{estado}", method=RequestMethod.GET)
    @Operation(summary = "Consultar citas por estado", description = "Permite consultar citas por su estado")
    public ResponseDTO consultarPorEstado(@PathVariable String estado) {
        var citas = service.listarCitas().stream()
            .filter(cita -> cita.estadoCita.equalsIgnoreCase(estado))
            .toList();
        
        if(citas.isEmpty()) {
            return new ResponseDTO("error", "No se encontraron citas con el estado: " + estado, "");
        }
        return new ResponseDTO("success", "", citas);
    }

    // consultar cita por cliente - Hacer endpoint cliente para usarlo aquí
    /* @RequestMapping(path = "/ConsultarCliente/{idCliente}", method=RequestMethod.GET)
    @Operation(summary = "Consultar citas por cliente", description = "Permite consultar citas por el ID del cliente")
    public ResponseDTO consultarPorCliente(@PathVariable int idCliente) {
        var citas = service.listarCitas().stream()
            .filter(cita -> cita.idCliente != null && cita.idCliente.idPersona == idCliente)
            .toList();
        
        if(citas.isEmpty()) {
            return new ResponseDTO("error", "No se encontraron citas para el cliente con ID: " + idCliente, "");
        }
        return new ResponseDTO("success", "", citas);
    }        */

    // Actualizar una cita por su ID
    @RequestMapping(path = "/Actualizar/{id}", method=RequestMethod.PUT)
    @Operation(summary = "Actualizar cita", description = "Permite actualizar una cita por su ID")
    public ResponseDTO actualizar(@PathVariable int id, @RequestBody Cita cita) {
        return new ResponseDTO("success", "", service.actualizarCita(id, cita));
    }
    
    // Actualizar el estado de una cita por su ID
    @RequestMapping(path = "/ActualizarEstado/{id}", method=RequestMethod.PUT)
    @Operation(summary = "Actualizar estado de cita", description = "Permite actualizar el estado de una cita por su ID")
    public ResponseDTO actualizarEstado(@PathVariable int id, @RequestBody Cita cita) {
        Cita citaActualizada = service.consultarCitaPorId(id).orElse(null);
        if (citaActualizada == null) {
            return new ResponseDTO("error", "Cita no encontrada", "");
        }
        citaActualizada.estadoCita = cita.estadoCita; // Actualiza el estado de la cita
        service.actualizarCita(id, citaActualizada);
        // Retorna solo el estado actualizado
        ResponseEstadoCitaDTO dto = new ResponseEstadoCitaDTO(citaActualizada.estadoCita);
        return new ResponseDTO("success", "Estado de la cita actualizado correctamente", dto);
    }
    
}
