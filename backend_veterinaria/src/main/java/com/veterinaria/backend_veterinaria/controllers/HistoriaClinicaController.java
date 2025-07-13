package com.veterinaria.backend_veterinaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.backend_veterinaria.DTOs.ResponseDTO;
import com.veterinaria.backend_veterinaria.models.HistoriaClinica;
import com.veterinaria.backend_veterinaria.services.HistoriaClinicaServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/HistoriaClinica")
@Tag(name = "Historia Clinica", description = "Permite gestionar las historias clinicas")

public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaServices service;

    // Listar todas las historias clinicas
    @RequestMapping(path = "/Listar", method = RequestMethod.GET)
    @Operation(summary = "Listar Historias Clinicas", description = "Permite listar las historias clinicas")
    public ResponseDTO listar() {
        return new ResponseDTO("success", "", service.listarHistoriasClinicas());
    }

    // Guardar una nueva historia clinica
    @RequestMapping(path = "/Guardar", method = RequestMethod.POST)
    @Operation(summary = "Guardar Historia Clinica", description = "Permite guardar una nueva historia clinica")
    public ResponseDTO guardar(@RequestBody HistoriaClinica historiaClinica) {
        return new ResponseDTO("success", "", service.guardarHistoriaClinica(historiaClinica));
    }

    // Eliminar una historia clinica por su ID
    @RequestMapping(path = "/Eliminar/{id}", method = RequestMethod.DELETE)
    @Operation(summary = "Eliminar Historia Clinica", description = "Permite eliminar una historia clinica por su ID")
    public ResponseDTO eliminar(@PathVariable Long id) {
        if (service.eliminarHistoriaClinica(id)) {
            return new ResponseDTO("success", "Historia clinica eliminada correctamente", "");
        }
        return new ResponseDTO("error", "Historia clinica no encontrada", "");
    }   

    // Consultar una historia clinica por su ID
    @RequestMapping(path = "/Consultar/{id}", method = RequestMethod.GET)
    @Operation(summary = "Consultar Historia Clinica por ID", description = "Permite consultar una historia clinica por su ID")
    public ResponseDTO consultar(@PathVariable Long id) {
        if (service.consultarHistoriaClinicaPorId(id).isEmpty()) {
            return new ResponseDTO("error", "Historia clinica no encontrada", "");
        }
        return new ResponseDTO("success", "", service.consultarHistoriaClinicaPorId(id));
    }

    // Consultar una historia clinica por nombre de mascota
    @RequestMapping(path = "/ConsultarPorMascota/{nombreMascota}", method = RequestMethod.GET)
    @Operation(summary = "Consultar Historia Clinica por Nombre de Mascota", description = "Permite consultar una historia clinica por el nombre de la mascota")
    public ResponseDTO consultarPorMascota(@PathVariable String nombreMascota) {
        if (service.consultarHistoriaClinicaPorNombreMascota(nombreMascota).isEmpty()) {
            return new ResponseDTO("error", "Historia clinica no encontrada para la mascota: " + nombreMascota, "");
        }
        return new ResponseDTO("success", "", service.consultarHistoriaClinicaPorNombreMascota(nombreMascota));
    }


    // Actualizar una historia clinica por su ID
    @RequestMapping(path = "/Actualizar/{id}", method = RequestMethod.PUT)
    @Operation(summary = "Actualizar Historia Clinica", description = "Permite actualizar una historia clinica por su ID")
    public ResponseDTO actualizar(@PathVariable Long id, @RequestBody HistoriaClinica historiaClinica) {
        return new ResponseDTO("success", "", service.actualizarHistoriaClinica(id, historiaClinica));
    }  
}
