package com.veterinaria.backend_veterinaria.DTOs;

import java.sql.Date;

public class HistoriaClinicaDTO {
    public Date fechaCreacion;
    public String sintomas;
    public String diagnostico;
    public String tratamiento;
    public Date fechaUltimaActualizacion;
    public String observaciones;
    public int idMascota;
    public int idPersona;    
}
