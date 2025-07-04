package com.veterinaria.backend_veterinaria.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.backend_veterinaria.models.Persona;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@RequestMapping("/Personas")
@Tag(name = "Personas", description = "Permite gestionar Cliente")

public class PersonaController {

    private ArrayList<Persona> listPersona = new ArrayList<>();

    @RequestMapping(path = "/Crear", method=RequestMethod.POST)
    @Operation(summary = "Crear una nueva persona", description = "Permite registrar una nueva persona en el sistema")
    public Persona crear(@RequestBody Persona persona) {
        listPersona.add(persona); 
        return persona; 
    }

    @RequestMapping(path = "/Listar", method = RequestMethod.GET)
    @Operation(summary = "Listado de personas", description = "Permite listar los clientes en el sistema")
    public ArrayList<Persona> listar(){
        return listPersona;
    }
    
    
    

}
