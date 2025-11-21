package com.pruebapracticabackend.pruebadevbackend.models.DTOs;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

public class SucursalRequestDTO {


    @NotBlank(message = "El nombre es Obligatio")
    private String nombreSucursal;
    
    private Long franquiciaDTO;

    public SucursalRequestDTO() {
    }

    public SucursalRequestDTO(@NotBlank(message = "El nombre es Obligatio") String nombreSucursal, Long franquiciaDTO) {
        this.nombreSucursal = nombreSucursal;
        this.franquiciaDTO = franquiciaDTO;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public Long getFranquiciaDTO() {
        return franquiciaDTO;
    }

    public void setFranquiciaDTO(Long franquiciaDTO) {
        this.franquiciaDTO = franquiciaDTO;
    }

}
