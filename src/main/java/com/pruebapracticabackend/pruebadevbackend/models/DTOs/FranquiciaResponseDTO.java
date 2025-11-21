package com.pruebapracticabackend.pruebadevbackend.models.DTOs;

import java.util.List;

import com.pruebapracticabackend.pruebadevbackend.models.Sucursal;


public class FranquiciaResponseDTO {

    private Long id;

    private String nombreFranquicia;

    private List<SucursalResponseDTO> listaSucursales;

    public FranquiciaResponseDTO() {
    }

    public FranquiciaResponseDTO(String nombreFranquicia, List<SucursalResponseDTO> listaSucursales) {
        this.nombreFranquicia = nombreFranquicia;
        this.listaSucursales = listaSucursales;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreFranquicia() {
        return nombreFranquicia;
    }

    public void setNombreFranquicia(String nombreFranquicia) {
        this.nombreFranquicia = nombreFranquicia;
    }

    public List<SucursalResponseDTO> getListaSucursales() {
        return listaSucursales;
    }

    public void setListaSucursales(List<SucursalResponseDTO> listaSucursales) {
        this.listaSucursales = listaSucursales;
    }

    
}
