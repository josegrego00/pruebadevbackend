package com.pruebapracticabackend.pruebadevbackend.models.DTOs;

import jakarta.validation.constraints.NotBlank;


public class FranquiciaRequestDTO {

    @NotBlank(message = "El nombre es Obligatorio")
    private String nombreFanquicia;
    
    public FranquiciaRequestDTO() {
    }

    public FranquiciaRequestDTO(@NotBlank(message = "El nombre es Obligatorio") String nombreFanquicia) {
        this.nombreFanquicia = nombreFanquicia;
    }

    public String getNombreFanquicia() {
        return nombreFanquicia;
    }

    public void setNombreFanquicia(String nombreFanquicia) {
        this.nombreFanquicia = nombreFanquicia;
    }


}
